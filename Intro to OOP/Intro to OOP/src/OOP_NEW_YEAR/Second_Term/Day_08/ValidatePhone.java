package OOP_NEW_YEAR.Second_Term.Day_08;

public interface ValidatePhone {
   static boolean validatePhoneNumber(String phoneNumber) throws WrongPhoneNumberException{
       try{
           Integer.parseInt(phoneNumber);
           if(phoneNumber.length() == 10) return true;
           else throw new WrongPhoneNumberException();
       } catch (NumberFormatException e) {
           throw new WrongPhoneNumberException();
       }
   }
}
