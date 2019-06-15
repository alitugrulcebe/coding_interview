package MySolutions.Beacon;

import java.io.File;

public class Test {


        public static void main(String[] args)
        {
            try{

                File afile =new File("C:\\temp\\A\\test1.txt");

                File newFile = new File("C:\\temp\\B\\test1.txt.new" + afile.getName());
                if(!newFile.exists())
                    if(afile.renameTo(newFile)){
                        System.out.println("File is moved successful!");
                    }else{
                        System.out.println("File is failed to move!");
                    }

            }catch(Exception e){
                e.printStackTrace();
            }
        }

}
