<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Countries</title>
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
    </style>
</head>
<body>

<table class="table table-success table-striped" border="3">
    <tr>
        <th> ID</th>
        <th> Name</th>
        <th> Is Visa</th>
        <th> Level Tourism</th>
        <th> Climate Types</th>
        <th> Description</th>
        <th> CreatedAt</th>
        <th> UpdatedAt</th>
        <th> DELETE</th>
        <th> UPDATE</th>
    </tr>
    <#list countries as item>
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.visa?string('yes', 'no')}</td>
            <td>${item.levelTourism}</td>
            <td>${item.climateTypes}</td>
            <td>${item.description}</td>
            <td>${item.createdAt}</td>
            <td>${item.updatedAt?if_exists}</td>
            <td><a class="btn btn-info" href="/ui/v1/countries/del/${item.id}" >Delete</a></td>
            <td><a class="btn btn-warning" href="/ui/v1/countries/edit/${item.id}">Update</a></td>
        </tr>
    </#list>
</table>

<h2>Add new Country</h2>

<!-- Trigger/Open The Modal -->
<button id="myBtn">Click to add</button>

<!-- The Modal -->
<div id="myModal" class="modal">

    <!-- Modal content -->
    <div class="modal-content">
        <span class="close">&times;</span>
        <p>Some text in the Modal..</p>
        <fieldset>
                <form action="/ui/v1/countries/" method="post">
                    <p>Name: <input type="text" name="name" /></p>
                    <p>Is Visa: <input type="checkbox" name="visa" /></p>
                    <p>Level Tourism: <input type="number" required="required" name="levelTourism" /></p>
                    <p>Climate Types:
                    <select name="climateTypes">
                        <#list enums as enum>
                            <option value="${enum}">${enum}</option>
                        </#list>
                    </select>
                    </p>

                    <p>Description: <input type="text" name="description" /></p>
                    <p><input type="submit" value="Submit" /><input type="reset" value="Reset" />
                </form>
        </fieldset>
    </div>

</div>

<div id="myModal1" class="modal">

    <!-- Modal content -->
    <div class="modal-content">
        <span class="close">&times;</span>
        <p id="Test1"></p>
    </div>

</div>

<script>
    // Get the modal
    var modal = document.getElementById("myModal");

    // Get the button that opens the modal
    var btn = document.getElementById("myBtn");

    // Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];

    // When the user clicks the button, open the modal
    btn.onclick = function() {
        modal.style.display = "block";
    }

    // When the user clicks on <span> (x), close the modal
    span.onclick = function() {
        modal.style.display = "none";
    }

    // When the user clicks anywhere outside of the modal, close it
    // window.onclick = function(event) {
    //     if (event.target == modal) {
    //         modal.style.display = "none";
    //     }
    // }
</script>


</body>
</html>