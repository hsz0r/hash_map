/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_hash_map;


/**
 *
 * @author hsz0r
 */
public class Test_hash_map {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            hash_map test = new hash_map(16);
            hash_map test2 = new hash_map(16);
            
           System.out.println(test.getLC());

            for (int i = 1; i < 100000; i++){
                test.add(i  , i);
            }
            System.out.println(test.toString());
            test.delete(1);

            System.out.println(test.toString());

            
//            System.out.println("===========");
//            
//            test2.setLC(0.75);
//            System.out.println(test2.getLC());
//            
//            for (int i = 1; i < 150; i++){
//                test2.add(i  , i);
//            }
//            System.out.println(test2.toString());
            
    }
    
}
