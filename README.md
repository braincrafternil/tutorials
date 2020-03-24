Hi there,

I completed all four question.

Coding part I completed  via Spring boot Frame with UI interface

 Also, I wrote code which is executed java main 

 (class name is Letsgoneo4j.java) I commented 

main method in this class, please review code detail 

I created Employees and Products nodes, I had plan to completed Relationship CRUD operation with 

Employees and Products, due to some production issue from office work, so I did not

entire relationship example but I create CRUD for individually for   Employees and Products Node



Here is its URL detail. While  in the  word document (Qu_Ans_with_Screen_shot.docx) with Screenshot.


Employee  URL Detail

Option ==1.(create new node and display Existing list )
http://localhost:8080/employee/new

http://localhost:8080/

http://localhost:8080/employee

Display Existing record and  Add new Record (link to) 

Option =2(Display employee via emp_id_)
http://localhost:8080/employee/show/{id}

http://localhost:8080/employee/show/40 

display Employee detail whose id =40 


option ==3(Display employee/s via empname)

http://localhost:8080/employee/view/{empname}

http://localhost:8080/employee/view/BB 

display Employee(s) detail whose name  =BB

option=4(display employee list which belong to empname or emp_id)
http://localhost:8080/employee/view/{empname}/{empid}
http://localhost:8080/employee/view/BB/40 

display Employee(s) detail whose empname  =BB or id=44

option=5(Edit Employee via emp_id_)
 http://localhost:8080/employee/edit/{empid}

http://localhost:8080/employee/edit/22

display Employee detail whose id =22 with Edit option. 

Option =6(Delete Employee via emp_id_)
http://localhost:8080/employee/delete/{emp_id} 
http://localhost:8080/employee/delete/23 

delete Employee detail whose id =23 and display remaining emp list.



Option =7(display employee list which belong to empname or emp_id)

http://localhost:8080/employee/view/{emp_name/{emp_id}
 

http://localhost:8080/employee/view/BB/23

display Employee List in  detail whose empname =BB  or emp_id =23



Product   URL Detail


Option ==1.(create new node and display Existing list )


http://localhost:8080/product/
or 
http://localhost:8080/product/new



option =2 

display product detail 



http://localhost:8080/product/show/39



option=3
display product list
http://localhost:8080/product/list

option=4

edit product detail and save it

http://localhost:8080/product/edit/39

option =5

delete product detail 

http://localhost:8080/product/delete/22
