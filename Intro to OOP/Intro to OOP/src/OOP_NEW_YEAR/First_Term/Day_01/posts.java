package OOP_NEW_YEAR.Day_01;

import java.util.ArrayList;
import java.util.Scanner;

public class posts {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<String> posts = new ArrayList<String>();

        System.out.println("Hello, would you like to:\n1. Create a new post\n2. Show all created posts");
        int choice = s.nextInt();
        System.out.println();

        if (choice == 1) {
            System.out.println();
        } else if (choice == 2){
            showPosts(posts);
        }
    }
    public String[] createPost(){
        Scanner s = new Scanner(System.in);
        String[] newPost = new String[2];
        System.out.println("Enter post name: ");
        newPost[0] = s.nextLine();
        System.out.println("Enter post info: ");
        newPost[1] = s.nextLine();

        return newPost;
    }
    public static void showPosts(ArrayList<String> posts){
        for (String post: posts){
            System.out.println(post);
        }
    }
}
