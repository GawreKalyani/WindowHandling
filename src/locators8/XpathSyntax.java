package locators8;

public class XpathSyntax {
	// there are two types of xpath 
	//Absolute and Relative

	// the xpath which starts with single forward slash '/' is Abs. xpath. not used at all in industry
	//the xpath which starts with double forward slash '//' is relative xpath. 	 	
			// means that any inetmediate node of html is started } 
			//   /html/body/div/div[2]/form/div[1]/input 
			//   1.    /html/body/div/div[2]/form/div[1]/input  
			//	2.  	//input[@id='email']  //*[@id="email"] 
			
			
			//standard syntax:   // tagName [ @ attr.Name =' attr.Value ' ] 
			//					 //input  [@id       ='email'     ]  
	/// normal std. syntax xpath's are not always locate unique elements on a page.
			
			//so we need some extra things in xpath that are called as xapth Axes.
			
			//1. text()-----// tagname[ text()='textofElement']
			//p[text()='Logout successfully'] //				
			//p[text()='Sign in to start your session']
			
			// 2. contains()-------this will used to match subString in text. 
			//tagName[contains (attr/fun , 'partVal')]

				//p[contains(text(),'Sys')]
				//h4[contains(text(),'PYTHON')]

	//3. following------  // current node      							   // target node 
			//tagName[@attr.Name='attr.Value']//following::tagName  
			//p[text()='Sign in to start your session']//following::h4 
			
		//4 . preceding------				 
			//p[text()='Sign in to start your session']//preceding::h4


	//5 following-sibling
	//tagName[]//following-sibling::tagName
			//b[contains(text(),'By')]//following-sibling::h4   Ex
			
	//6.  preceding-sibling
	//tagName[]//preceding-sibling::tagName
			//h4[contains(text(),'JAVA')]//preceding-sibling::b
			
	//7. parent

	//tagName[]//parent::tagName
			                      //b[contains(text(),'By')]//parent::a    loginpgex  //p//parent::div
			
	//8. child

	//tagName[]//child::tagName
					//body[@class='hold-transition login-page']//child::div/center
					//h1//child::small[text()='Courses Offered']
			
	//In USER Table locate 
	//Delete Button  as //tr[2]/td/a/span    or  //tr[2]//span
	//locates delete button but not clickable  //tr[2]/td[8]

			
	//In Operators Table ROW3 locate WhatsApp /Phone Call/sms option button
//	      //tr[3]//span   locate WhatsApp  
//	      //tr[3]//span[text()='Phone Call']
//	    //tr[3]//span[text()='SMS']   or  //tr[5]//span[text()='Whats App']
			
			
	//LOGOUT button on DASHBOARD page
//	    //a[text()='LOGOUT'] or driver.findElement(By.partialLinkText("LOGOUT"));
	
/*	1. //Tagname[@attr='attrVal']
	2. //Tagname[text()='textValue']
	3.//TagNm[contains(text(),'partialValue')]
	4.//TagNm[contains(@attr,'patialAttrValue')]
	5.//currentNodeTag//following::targetNodeTag
	6.//currentNodeTag//preceding::targetNodeTag
	7.//currentNodeTag//following-sibling::targetNodeTag
	8.//currentNodeTag//preceding-sibling::targetNodeTag
	9. //parentNodeTag//child::childTag
	10.//childNodeTag//parent::parentNodeTag
*/}
