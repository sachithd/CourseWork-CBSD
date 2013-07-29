<%-- 
    Document   : index
    Created on : Apr 11, 2012, 7:42:38 PM
    Author     : Sachith
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Management</title>
    </head>
    <body>
        <h1>Customer Management</h1>
        <h2>Customer Records</h2>
        <ul>
            <li><a href="/CusManagement/addNewCustomer.html">Add Customer</a></li>
            <li><a href="/CusManagement/deleteCustomer.html">Remove Customer</a></li>
            <li><a href="/CusManagement/updateCustomer.html">Update Customer</a></li>
            <li><a href="/CusManagement/findCustomer.html">Find Customer</a></li>
            <li><form method="post" action="/CusManagement/CustomerOperations">
                    <input name="btnSubmit" value="View All Customers" type="submit">
                    <input type="hidden" name="Operation" value="viewCustomer"><div style="text-align: left;">Database :
                        <select size="1" name="Database"><option value="DaghenamDB" selected="selected">DaghenamDB</option><option value="StratfordDB">StratfordDB</option></select>
                        <br>
                    </div>  
                </form></li>
        </ul>
        
        <h2>Country Records</h2>
        <ul>
            <li><a href="/CusManagement/addNewCountry.html">Add Country</a></li>
            <li><a href="/CusManagement/deleteCountry.html">Remove Country</a></li>
            <li><a href="/CusManagement/updateCountry.html">Update Country</a></li>
            <li><a href="/CusManagement/findCountry.html">Find Country</a></li>
            <li><form method="post" action="/CusManagement/CountryOperations">

                    <input name="btnSubmit" value="View All Countries" type="submit">
                    <input type="hidden" name="Operation" value="viewCountry"> <div style="text-align: left;">Database :
                        <select size="1" name="Database"><option value="DaghenamDB" selected="selected">DaghenamDB</option><option value="StratfordDB">StratfordDB</option></select>
                        <br>
                    </div> 
                </form></li>
        </ul>
         <h2>Address Records  (* To be implemented)</h2>
        <ul>
            <li><a href="/CusManagement/addNewAddress.html">Add Address</a></li>
            <li><a href="/CusManagement/deleteAddress.html">Remove Address</a></li>
            <li><a href="/CusManagement/updateAddress.html">Update Address</a></li>
            <li><a href="/CusManagement/findAddress.html">Find Address</a></li>
            <li><form method="post" action="/CusManagement/AddressOperations">
                    <input name="btnSubmit" value="View All Addresses" type="submit">
                    <input type="hidden" name="Operation" value="viewAddress"><div style="text-align: left;">Database :
                        <select size="1" name="Database"><option value="DaghenamDB" selected="selected">DaghenamDB</option><option value="StratfordDB">StratfordDB</option></select>
                        <br>
                    </div>  
                </form></li>
        </ul>
    </body>
</html>
