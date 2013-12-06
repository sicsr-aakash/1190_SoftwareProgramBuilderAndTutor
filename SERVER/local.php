<?php

	$username = $_POST['uname'];
	$password = $_POST['pwd'];
	
	$fullstring = $username;
	#echo "<valid>$fullstring</valid>";
	
                #$output = shell_exec('bash exec.sh');
                #echo $output."this was output";
                
                $file = 'output.cpp';
                file_put_contents($file,$fullstring);
		$flag = shell_exec('bash exec.sh');
		$output = file_get_contents('output.txt');
		$check = null;
		$check = file_get_contents('flag.txt');
		shell_exec('rm output.txt');
		shell_exec('rm output.cpp');
		echo $output;
		/*if(isset($check))
		{
			$remove = shell_exec('rm flag.txt');
			echo "Your Programme Contains Errors".$output.$check;
		}
		else
		{
			echo $output;
		}
		*/
?>
