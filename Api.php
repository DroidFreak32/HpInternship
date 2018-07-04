
 
<?php 

 define('DB_HOST', 'localhost');
 define('DB_USER', 'root');
 define('DB_PASS', '');
 define('DB_NAME', 'demo');
 

 $conn = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);
 

 if (mysqli_connect_errno()) {
 echo "Failed to connect to MySQL: " . mysqli_connect_error();
 die();
 }
 

 $stmt = $conn->prepare("SELECT username,email,gender FROM register;");
 

 $stmt->execute();
 

 $stmt->bind_result($username, $email, $gender);
 
 $products = array(); 
 
 //traversing through all the result 
 while($stmt->fetch()){
 $temp = array();
 $temp['email'] = $email;
 $temp['username'] = $username;
 $temp['gender'] = $gender;


 array_push($products, $temp);
 }
 
 
 echo json_encode($products);
 
 ?>