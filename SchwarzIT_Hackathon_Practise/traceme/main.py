#!/usr/bin/env python3
"""
Recover FLAG{...} even when characters are split/interleaved in the hex blob.

Approach:
 - decode hex -> bytes
 - for each occurrence of 'F', take a lookahead window of MAX_WINDOW bytes
 - filter the window keeping only allowed printable chars (by default A-Z 0-9 _ { })
 - search the filtered string for FLAG{...} (regex)
 - print matches with context and approximate byte-range in the original blob

Adjust MAX_WINDOW and ALLOWED_CHARS if needed.
"""
import binascii, re, sys

HEX_STR = (
"1a5721a820053e1eb56192640800450205a084dd0000f40698260321eb12ac140a0a01bbf8912d277db527ecce8280100100dfbb00000101080a6afdb61b63f60a712037bf452cda5b3075b8e94d687352e38a05cc07a2b4ce1be6cd35068b80d719c13717a4d7a4ca550bc70b46e76871c0fa0ca7184ab096b3493abef2b8467ccb014f401e3e20e4df22c8d186d0d51ca60f2014243d5bdf0a7a926f487ab7cfa2101b70cd7f03e0dde93183849003d46332ab4f1908019d4b7d0175f4410257007beb336d52793e05dd939ec15b24a424ea6170ed5ee3c61afd8b055421299ca84dc59155993c30613c993a0d47875d0176f668e2c09d6f1e17a62a666d3629633328c6a8da8d49740ba5efdd6bb9bb993b80241297a3d0326894c900b9c5693e48c03ed05036d1b2ca321591cfef076ec419094235ee2831817bc50db1d7e6be40ee8ef848a62d4faa6317db5ab892429ab3eea057e90e56ef9c4fcb87bd57789867f5c116f47e28247847a652e9930ceb83895df60fe1a78c732a4c8c7341913d646bd8c82e974452f5bc41bf589cc9d1c7230a5b79b86726710af7b1e690f36b6031d0ef1e833877db879838c12caaa8e06f3324abccc9cc9e1a40336ac859b0f8660cdb461c9e3659bff514d034cb7c0c26bab45fda044a195be1c37b6051140af607401237ee9bd282cc996cdc f4a5d8246d16c2672cc97f8e4c834c5da4daf5c22b15a55bbb139456a774ffa679f57abb77617980d94a24dad60f5d55ae75ca3668a7b206b66853611f3082644856a8a356eb27bae2edaa5b996fce3aa583444575f8df0a6c95e6d1623c4f4498f3c5124a51e41d9fd2f6bb5c8977023a3fa9a352c4008389da71fd9903ee25253b826fec9101270b9f8a82d484140d41ef6cd3c61ff08ac8efee55a7f519696b2c4d890cb7eeb8eb5b1ed2593372178befeacbf2033fb88011c71395ae5c5b1ed8764cb32d5dd0abd33bdc3b4c94aa9746e10fe43cbd8ef5f65441fc31204c55e344fad82f5964146b0531011ecf9959200f55cab7a52559cce6241024d3f60634e168098e80f673736f533bd339fde1064da0d3a4678b4b1909925ea136f51b18b3bebd5b5419ff6ecec9969013d8830886ed56eab93a1e5490373c72cef0a859340662ed342a346590ad816e262ae7f55fdb8e91045af1c83c16c1b5c0b5825a06871caff8b3e7695ccd25bb1ed1290594d407e1474ab4b4afc64b104d31eefd4e304cd628b74bf27c71ee361b8ea792307330105ea97d33be672ef5febb9a801dcf2f00c03a60155815ee7be152c6317455d5e79ffc42030e2bbb144abd2f8bf3777d85bf82a37380107b7970d8eb1f6ff7f5124ecd2498f0d401b0f3e2f4f2285c180d0432061a3dda0c3c9ca4cf3547d8a85d6929c919cf6a9ce184c55370468562930a88bbb823a3448ebd5f24baa2dd27365694abd6db8aa2895efee3e9533d1cf22c1f6b56784bb6d4ed8e97e17f8d69ffc4cdd206d42b5a8522f9e46a4dbbec2242daa35e729285f181a9dca642210de0e40f25a40c6cbb40069853ab35fc1302326da1e2a7b021ada51aa575807223741365138793032b85043016cf7fe11ac122d6bf6191ed0c3eca35b39d31a59b399e231e4a2517f5c4513764fe18bf22310fbd4d8ceac718ab056da11928db9c7588a70259f5177ef0b23eacdf74069a0cfb4a0c9044a6cda008da22ac407bc43f044da75a810cffeb08b130b6a70fca413c7e9f77562c3864abb7b83a41b92c8722528c4b2e8b689450cf2eaeb67b0be0402586751dd6949c220c8bb82e97bac0f3af750c1a76681e08cf6708eeece9ca7b3f93fd1c5b9989e2e81d88a24c8c512d36c8fe8b4eb6120a386fccd01de031bc706970464a9c551ca798907fbdfc46586baa8f0add468b0ae7b6f3aceedb62d7fde70be45df8621736c34092c715129a852036ed9489e5fd432643db81d2f630eb7695c387b4f155bc02d05ef80965e18b893b5ceff7dc85160210e891bc05c8463ea3c9b80da11c9cfb9985bf00c78918a341be4067"
)

# Regex used to report final matches (uppercase letters, digits and underscore)
FLAG_RE = re.compile(r'FLAG\{[A-Z0-9_]+\}')

# How many bytes ahead to consider from each 'F' (increase if needed)
MAX_WINDOW = 2000

# Allowed characters to keep when filtering a window (tune as needed)
ALLOWED = set("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_{}")

def hex_to_bytes(h):
    clean = re.sub(r'\s+', '', h)
    try:
        return binascii.unhexlify(clean)
    except Exception as e:
        print("hex decode error:", e)
        sys.exit(1)

def filter_window_bytes(b):
    # convert to str with latin1 (1:1 mapping) then keep only allowed chars
    s = b.decode('latin1')
    return ''.join(ch for ch in s if ch in ALLOWED)

def find_flags_in_split_blob(raw_bytes):
    s = raw_bytes.decode('latin1')
    results = []
    # precompute indices of 'F' to start windows
    f_positions = [i for i,ch in enumerate(s) if ch == 'F']
    if not f_positions:
        # no 'F' present; still try scanning whole blob once
        f_positions = [0]

    for start in f_positions:
        end = min(len(raw_bytes), start + MAX_WINDOW)
        window = raw_bytes[start:end]
        filtered = filter_window_bytes(window)
        for m in FLAG_RE.finditer(filtered):
            # We report the filtered-match and the window start/end in original bytes
            results.append({
                'match': m.group(0),
                'filtered_context': filtered[max(0,m.start()-20):m.end()+20],
                'window_range': (start, end),
            })
    return results

def main():
    raw = hex_to_bytes(HEX_STR)
    matches = find_flags_in_split_blob(raw)
    if not matches:
        print("No matches found with current settings.")
        print("Try increasing MAX_WINDOW or expanding ALLOWED set to include lowercase or other chars.")
        return
    print("Matches found:")
    for i, r in enumerate(matches,1):
        print(f"{i}) {r['match']}  (window bytes {r['window_range'][0]}..{r['window_range'][1]})")
        print(f"   context (filtered): ...{r['filtered_context']}...")
    # dedupe and print unique flags
    uniq = sorted({r['match'] for r in matches})
    print("\nUnique flags found:")
    for u in uniq:
        print(u)

if __name__ == '__main__':
    main()
