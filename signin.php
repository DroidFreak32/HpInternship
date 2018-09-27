<?php

define("db_name","demo");
define("mysql_username","root");
define("mysql_password","");
define("server_name","localhost");



$response=array();


$con=mysqli_connect(server_name,mysql_username,mysql_password,db_name);
   if(mysqli_connect_errno())
   {
	   echo "could not connect to the database".mysqli_connect_error();
	  die(); 
   }
$username=$_POST['username'];
$email=$_POST['email'];
$password=$_POST['password'];
$gender=$_POST['gender'];

$sql="INSERT INTO register VALUES('$username','$email','$password','$gender')";


 if(mysqli_query($con,$sql)) 
 {  global $response;
	 $response['error']=false;
	 $response['message']="$username Registered successfully";
 }
else
{
	 $response['error']=true;
	 $response['message']=mysqli_error($con);

}
 
   echo json_encode($response);
 ?>
   
