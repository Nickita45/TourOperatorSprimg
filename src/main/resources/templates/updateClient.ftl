<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <#include "less.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

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
            <li><a href="https://www.youtube.com/channel/UCDfZM0IK6RBgud8HYGFXAJg" target="_blank">YouTube</a></li>
            <li><a href="https://www.linkedin.com/in/plavookac/" target="_blank">Linkedin</a></li>
        </ul>
    </div>

    <div id='center' class="main center">
        <h3 align="center">Change country "${item.name}"</h3>
        <div style="display: flex; margin: 0" >
            <div style="min-height: 10em; display: table-cell; margin-left: auto;margin-right: auto; width: 25em;" class="shadow p-3 mb-5 bg-body rounded" >
    <fieldset>
        <form action="" method="post">
            <p><input type="hidden" name="id" value="${item.id}"></p>
            <p>Name: <input type="text" name="name" value="${item.name}" class="form-control"/></p>

            <p>First Name: <input type="text" name="firstName" class="form-control" value="${item.firstName}" required="required"/></p>
            <p>Last Name: <input type="text" name="lastName" class="form-control" value="${item.lastName}" required="required"/></p>
            <p>Patronymic: <input type="text" name="patronymic" class="form-control" value="${item.patronymic}"/></p>
            <p>Adress: <input type="text" name="address" class="form-control" value="${item.address}"/></p>
            <p>Phone: <input type="text" name="phone" class="form-control" value="${item.phone}"/></p>


            <p>Description: <input type="text" name="description" value="${item.description}" class="form-control"/></p>
            <p><input type="submit" value="Submit" class="btn btn-primary"/>
                <input type="reset" value="Reset" class="btn btn-secondary"/>
        </form>
    </fieldset>
    </div>
            </div>
            </div>

</body>
</html>