import java.util.*;
import java.io.*;

//////////////////////////////////////////////////////////////
//
//  class :         MarvellousPacker
//  Description :   This class is used to pack the Multiple files into one file
//  Author  :       Sakshi Pankaj Borhade
//
//////////////////////////////////////////////////////////////

class MarvellousPacker
{
    private String PackName;
    private String DirName;

    public MarvellousPacker(String A, String B)
    {
        this.PackName = A;
        this.DirName = B;
    }

    ///////////////////////////////////////////////////////////////////////
    //
    //  Function Name :     PackingActivity
    //  Description :       It is used to Pack Multiple files into a one file
    //  Input :             It accepts Nothing
    //  Output :            It returns Nothing
    //  Author :            Sakshi Pankaj Borhade
    //  Date :              21/07/2025
    //
    ///////////////////////////////////////////////////////////////////////

    public void PackingActivity()
    {
        try
        {
            System.out.println("---------------------------------------------------------");
            System.out.println("---------------Marvellous Packer Unpacker----------------");
            System.out.println("---------------------------------------------------------");
            System.out.println("-------------------Packing Activity----------------------");
            System.out.println("---------------------------------------------------------");

            int i = 0, j = 0, iRet = 0, iCountFile = 0;

            File fobj = new File(DirName);

            //check the exixtence of directory
            if((fobj.exists() && fobj.isDirectory()))
            {
                System.out.println(DirName + " is Succesfully opened");

                File Packobj = new File(PackName);

                //create a packed file
                boolean bRet = Packobj.createNewFile();

                if(bRet == false)
                {
                    System.out.println("Unable to create pack file");
                    return;
                }

                System.out.println("Packed file gets successfully created with name "+PackName);

                //retreive all files from directory
                File Arr[] = fobj.listFiles();       

                //Packed file object
                FileOutputStream foobj = new FileOutputStream(Packobj);

                //Buffer for read amd write activityy
                byte Buffer[] = new byte[1024];

                String Header = null;

                // directory traversal loop
                for(i = 0; i < Arr.length; i++)
                {
                    Header = Arr[i].getName() +" "+ Arr[i].length();
                    

                    // white spaces add karyla loop 100 bytes
                    for(j = Header.length(); j < 100; j++)
                    {
                        Header = Header + " ";
                    }

                    //write header into packed file
                    foobj.write(Header.getBytes());

                    //open file from directory for reading
                    FileInputStream fiobj = new FileInputStream(Arr[i]);

                    //write contents of file into packed file
                    while((iRet = fiobj.read(Buffer)) != -1)
                    {
                        foobj.write(Buffer,0,iRet);
                        System.out.println("File name scanned : "+Arr[i].getName());
                        System.out.println("file size read is : "+iRet);
                    }

                    fiobj.close();
                    
                    //How many files gets packed
                    iCountFile++;
                }

                System.out.println("Packing Activity done");

                System.out.println("---------------------------------------------------------");
                System.out.println("-------------------Statistical Report--------------------");
                System.out.println("---------------------------------------------------------");

                // to be add
                System.out.println("Total files packed "+iCountFile);

                System.out.println("---------------------------------------------------------");
                System.out.println("----------Thank you for using our Application------------");
                System.out.println("---------------------------------------------------------");
            }
            else
            {
                System.out.println("There is no such directory");
            }
        } // end of try
        catch(Exception eobj)
        {}
    } // End of Packingactivity method
} // end of marvellousPacker class

////////////////////////////////////////////////////////////////
//
// Entry Point function of the project
//
////////////////////////////////////////////////////////////////

class Packer
{
    public static void main(String A[])
    {
        try
        {
            Scanner sobj = new Scanner(System.in);

            System.out.println("Enter the name of directory that you want to pack: ");
            String DirName = sobj.nextLine();

            System.out.println("Enter the name of File that you want to create for packing: ");     
            String PackName = sobj.nextLine();

            MarvellousPacker mobj = new MarvellousPacker(PackName, DirName);

            mobj.PackingActivity();        
        }
        catch(Exception eobj)
        {}
    } // End of main
} // End of Packer class
