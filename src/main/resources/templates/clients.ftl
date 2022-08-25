<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Clients</title>
    <#include "less.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

    <style>
        body {font-family: Arial, Helvetica, sans-serif;}

        /* The Modal (background) */
        .modal {
            display: none; /* Hidden by default */
            position: fixed; /* Stay in place */
            z-index: 1; /* Sit on top */
            padding-top: 100px; /* Location of the box */
            left: 0;
            top: 0;
            width: 100%; /* Full width */
            height: 100%; /* Full height */
            overflow: auto; /* Enable scroll if needed */
            background-color: rgb(0,0,0); /* Fallback color */
            background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
        }

        /* Modal Content */
        .modal-content {
            background-color: #fefefe;
            margin: auto;
            padding: 20px;
            border: 1px solid #888;
            width: 80%;
        }

        /* The Close Button */
        .close {
            color: #aaaaaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: #000;
            text-decoration: none;
            cursor: pointer;
        }
        td {
            vertical-align: middle;
        }
    </style>
</head>
<body>

<div class="header"></div>
<input type="checkbox" class="openSidebarMenu" id="openSidebarMenu">
<label for="openSidebarMenu" class="sidebarIconToggle">
    <div class="spinner diagonal part-1"></div>
    <div class="spinner horizontal"></div>
    <div class="spinner diagonal part-2"></div>
</label>
<div id="sidebarMenu">
    <ul class="sidebarMenuInner">
        <li>Plotnikov Mykyta<span>Java Spring Developer</span></li>
        <li><a href="/">HOME</a></li>
        <li><a href="/ui/v1/countries/">country</a></li>
        <li><a href="/ui/v1/clients/">clients</a></li>
        <li><a href="/ui/v1/routes/">routes</a></li>
        <li><a href="/ui/v1/vouchers/">vouchers</a></li>
        <li><a href="/ui/v1/umlDiagram/">uml diagram</a></li>
    </ul>
</div>
<div id='center' class="main center">
    <div class="mainInner">
        <div>

    <h3>Client information</h3>
    <table class="table table-success table-striped" style="vertical-align: center" border="3">
        <tr style="font-weight: bold">
            <th> ID</th>
            <th> Name</th>
            <th> First Name</th>
            <th> Last Name</th>
            <th> Patronymic</th>
            <th> Address</th>
            <th> Phone</th>
            <th> Discount %</th>
            <th> Description</th>
            <th> CreatedAt</th>
            <th> UpdatedAt</th>
            <th> DELETE</th>
            <th> UPDATE</th>
        </tr>
        <#list clients as item>
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.firstName}</td>
                <td>${item.lastName}</td>
                <td>${item.patronymic}</td>
                <td>${item.address}</td>
                <td>${item.phone}</td>
                <td>${item.discountPercentage}</td>

                <td>${item.description}</td>
                <td>${item.createdAt}</td>
                <td>${item.updatedAt?if_exists}</td>
                <td><a class="btn btn-info" href="/ui/v1/clients/del/${item.id}" >Delete</a></td>
                <td><a class="btn btn-warning" href="/ui/v1/clients/edit/${item.id}">Update</a></td>
            </tr>
        </#list>
    </table>

    <h4>Add new Client</h4>

    <!-- Trigger/Open The Modal -->
    <button id="myBtn" class="btn btn-success">Click to add</button>

    <!-- The Modal -->


        </div>
    </div>
</div>

<div id="myModal" class="modal">
    <div class="modal-dialog">
    <!-- Modal content -->
    <div class="modal-content">

        <div class="modal-header">
            <h4 class="modal-title" id="exampleModalLabel">Add new client</h4>
            <span class="close">&times;</span>
        </div>
            <fieldset>
                <form action="/ui/v1/clients/" method="post">
                    <div class="modal-body">
                    <label class="col-form-label">Name:</label>
                        <input type="text" name="name" class="form-control"/>
                        <p>First Name: <input type="text" name="firstName" class="form-control" required="required"/></p>
                        <p>Last Name: <input type="text" name="lastName" class="form-control" required="required"/></p>
                        <p>Patronymic: <input type="text" name="patronymic" class="form-control"/></p>
                        <p>Adress: <input type="text" name="address" class="form-control"/></p>
                        <p>Phone: <input type="text" name="phone" class="form-control"/></p>
                        <p>Description: <input type="text" name="description" class="form-control"/></p>

                    </div>
                    <div class="modal-footer">
                        <input type="submit" value="Submit" class="btn btn-primary"/>
                        <input type="reset" class="btn btn-secondary" value="Reset" />
                    </div>
                </form>

            </fieldset>


    </div>
    </div>
</div>


<script>
    // Get the modal
    var modal = document.getElementById("myModal");

    // Get the button that opens the modal
    var btn = document.getElementById("myBtn");

    // Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];
    modal.onload = function ()
    {
        modal.style.display = "none";
    }

    // When the user clicks the button, open the modal
    btn.onclick = function() {
        modal.style.display = "block";
    }

    // When the user clicks on <span> (x), close the modal
    span.onclick = function() {
        modal.style.display = "none";
    }

        // When the user clicks anywhere outside of the modal, close it
     window.onclick = function(event) {
         if (event.target == modal) {
             modal.style.display = "none";
        }
     }
</script>


</body>
</html>