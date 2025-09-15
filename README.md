===================================================================
             MARVELLOUS PACKER AND UNPACKER APPLICATION
===================================================================

Author       : Sakshi Pankaj Borhade  
Created On   : 21/07/2025  
Language     : Java  
Input        : Files from a directory (Packer), Packed file (Unpacker)  
Output       : Single packed file (Packer), Multiple extracted files (Unpacker)  

===================================================================
DESCRIPTION
===================================================================

This Java-based console application is designed to:
1. **Pack multiple files** from a specified directory into a **single file**
2. **Unpack files** from a previously packed file, restoring them individually

These tools are helpful for basic file bundling or archiving tasks, such as:
- Submitting multiple source code files
- Simple backup operations
- Consolidating files for transfer

===================================================================
FEATURES
===================================================================

✔ Pack multiple files into a single file  
✔ Extract all files from the packed file  
✔ Displays logs and statistical reports  
✔ Handles all file types (text, binary, images, etc.)  
✔ Easy command-line interface  
✔ No external dependencies  

===================================================================
PACKER DETAILS
===================================================================

> **Class Name**: `MarvellousPacker`  
> **Entry Point**: `Packer.java`

### Functionality:

- Accepts a directory name and a target packed file name
- Reads all files from the directory
- Creates a 100-byte header for each file:  
  `"filename filesize"` (padded with spaces)
- Writes the header and file data to the packed file
- Prints progress and a summary report

===================================================================
UNPACKER DETAILS
===================================================================

> **Class Name**: `MarvellousUnpacker`  
> **Entry Point**: `Unpacker.java`

### Functionality:

- Accepts a packed file name
- Reads 100-byte headers and extracts file names and sizes
- Writes the corresponding file data to new files
- Prints progress and a summary report
