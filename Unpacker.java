import java.util.*;
import java.io.*;

//////////////////////////////////////////////////////////////
//
//  class :         MarvellousUnpacker
//  Description :   This class is used to Unpack the Multiple files from one file
//  Author  :       Sakshi Pankaj Borhade
//
//////////////////////////////////////////////////////////////

class MarvellousUnpacker
{
    private String PackName;

    public MarvellousUnpacker(String A)
    {
        this.PackName = A;
    }

    ///////////////////////////////////////////////////////////////////////
    //
    //  Function Name :     UnpackingActivity
    //  Description :       It is used to Unpack Multiple files From one file
    //  Input :             It accepts Nothing
    //  Output :            It returns Nothing
    //  Author :            Sakshi Pankaj Borhade
    //  Date :              21/07/2025
    //
    ///////////////////////////////////////////////////////////////////////

    public void UnpackingActivity()
    {
        try
        {
            System.out.println("---------------------------------------------------------");
            System.out.println("---------------Marvellous Packer Unpacker----------------");
            System.out.println("---------------------------------------------------------");
            System.out.println("-------------------Unpacking Activity----------------------");
            System.out.println("---------------------------------------------------------");

            String Header = null;
            File fobjnew = null;
            int Filesize = 0, iRet = 0, iCountFile = 0;
            
            File fobj = new File(PackName);

            //if packed file is not present
            if(!fobj.exists())
            {
                System.out.println("Unable to access packed file");
                return;
            }

            System.out.println("Packed file gets succesfully opened");

            FileInputStream fiobj = new FileInputStream(fobj);

            //buffer to read the header
            byte HeaderBuffer[] = new byte[100];

            //Scan the packed file to extract the files from it
            while((iRet = fiobj.read(HeaderBuffer,0,100)) != -1)
            {
                //converting byte array to string
                Header = new String(HeaderBuffer);

                Header = Header.trim();

                //Tokenized the header into two parts
                String Tokens[] = Header.split(" ");
                
                fobjnew = new File(Tokens[0]);

                //create new file to extract
                fobjnew.createNewFile();

                Filesize = Integer.parseInt(Tokens[1]);

                //create new buffer to store files data
                byte Buffer[] = new byte[Filesize];

                FileOutputStream foobj = new FileOutputStream(fobjnew);

                //read the data from packed file
                fiobj.read(Buffer,0,Filesize);

                //write the data into extracted file
                foobj.write(Buffer,0,Filesize);

                System.out.println("File unpacked with name "+Tokens[0] + "Having size "+Filesize);

                iCountFile++;

                foobj.close();
            }// end of while

            System.out.println("---------------------------------------------------------");
            System.out.println("-------------------Statistical Report--------------------");
            System.out.println("---------------------------------------------------------");

            System.out.println("Total number of files unpacked : "+iCountFile);

            System.out.println("---------------------------------------------------------");
            System.out.println("----------Thank you for using our Application------------");
            System.out.println("---------------------------------------------------------");

            fiobj.close();
        }
        catch(Exception eobj)
        {}
    }
}

////////////////////////////////////////////////////////////////
//
// Entry Point function of the project
//
///////////////////////////////////////////////////////////////

class Unpacker
{
    public static void main(String A[])
    {
        try
        {        
            Scanner sobj = new Scanner(System.in);
    
            System.out.println("Enter the name of File which contains packed data: ");     
            String PackName = sobj.nextLine();
            
            MarvellousUnpacker mobj = new MarvellousUnpacker(PackName);

            mobj.UnpackingActivity();
        }
        catch(Exception eobj)
        {}
    } // End of main
} // End of Unpacker class
