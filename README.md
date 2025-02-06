# 🏦 Bank Management System  

A **comprehensive Java-based banking system** with a **graphical user interface (GUI)** that simulates basic banking operations. This application provides **separate interfaces for customers and administrators** to manage banking activities efficiently, using **file handling** for data persistence.  
<p align="center">
  <img src="https://github.com/user-attachments/assets/7119c125-2714-436d-ad8e-f83ed82df843" alt="Flappy Bird GIF">
</p>



## 🚀 Features  

### 👤 Customer Features  
- **Account Management**  
  - Create new bank account  
  - Activate account  
  - Delete existing account  
  - Login to account  

- **Transaction Operations**  
  - Deposit money  
  - Withdraw money  
  - Transfer money to other accounts  
  - Check account balance  

- **Loan Management**  
  - Apply for loans  
  - View loan status  
  - Pay loan installments  
  - Check payable loan amount  

### 🔑 Administrator Features  
- **Secure Admin Panel**  
  - Protected login system  
  - Full administrative control over banking operations  

- **Account Management**  
  - View and manage account details  
  - Provide checkbook facility  
  - Manage account statuses  

- **Interest Rate Management**  
  - Set and update bank interest rates  
  - Modify interest policies  

### 🔒 Security Features  
- Password protection  
- Input validation  
- CNIC verification  
- Phone number verification  
- **Secure file handling for data storage**  



## ⚙️ Technical Details  

### 🛠 Built With  
- **Java**  
- **Swing** (for GUI)  
- **File Handling** (File I/O) for data persistence  

### 💻 System Requirements  
- **Java Development Kit (JDK) 8+**  
- **Minimum 2GB RAM**  
- **Windows/Linux/MacOS operating system**  



## 🏗 Installation  

### 1️⃣ Clone the Repository  
``` bash  
 git clone https://github.com/yourusername/bank-management-system.git  
```
### 2️⃣ Navigate to the Project Directory  
``` bash  
 cd bank-management-system  
```
### 3️⃣ Compile the Java Files  
``` bash  
 javac src/com/company/*.java  
```
### 4️⃣ Run the Application  
``` bash  
 java src/com/company/Runner  
```


## 📌 Usage  

### 🔹 For Customers  
1. **Launch the application**  
2. Select **"ACCOUNT HOLDER"** from the main menu  
3. Choose from available options:  
   - Login to existing account  
   - Create new account  
   - Activate account  
   - Delete account  

### 🔹 For Administrators  
1. **Launch the application**  
2. Select **"ADMIN"** from the main menu  
3. **Login with admin credentials:**  
   - **Default Admin ID:** `1122`  
   - **Default Password:** `abd`  
4. Access **admin features:**  
   - Update interest rates  
   - Manage checkbook requests  
   - View admin information  



## 📁 File Structure  
``` plaintext  
 src/com/company/  
 ├── Account.java                 # Account class definition  
 ├── AccountFileOperations.java   # Account data management  
 ├── Admin.java                   # Admin class definition  
 ├── AdminFileOperations.java     # Admin data management  
 ├── GUI Classes                  # Various GUI implementation files  
 └── Runner.java                  # Main application entry point  
```


## 💾 Data Persistence  
- **Account information** is stored in `Accounts.txt`  
- **Admin data** is stored in `Admin.txt`  
- **File handling & object serialization** for data storage  



## 🛠 Contributing  
1. **Fork the repository**  
2. **Create your feature branch** (`git checkout -b feature/AmazingFeature`)  
3. **Commit your changes** (`git commit -m 'Add some AmazingFeature'`)  
4. **Push to the branch** (`git push origin feature/AmazingFeature`)  
5. **Open a Pull Request**  



## 💡 Acknowledgments  
- **Java Swing** for GUI components  
- **File Handling (File I/O)** for data persistence  
- **Object-Oriented Programming (OOP) Principles**  



## 📞 Support  
For support, **email** `rafaybbx@gmail.com` or **create an issue** in the repository.  



## ✨ Authors  
- **Abdul Rafay**  



## 📌 Version History  
- **1.0.0**  
  - Initial Release  
  - Basic banking features  
  - Admin panel implementation 

## 📜 License  
This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for details.  
 



