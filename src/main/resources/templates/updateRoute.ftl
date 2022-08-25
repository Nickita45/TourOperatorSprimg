<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Routelog update</title>
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
        <h3 align="center">Change routelog "${item.route.name}"</h3>
        <div style="display: flex; margin: 0" >
            <div style="min-height: 10em; display: table-cell; margin-left: auto;margin-right: auto; width: 25em;" class="shadow p-3 mb-5 bg-body rounded" >
    <fieldset>
        <form action="" method="post">
            <p><input type="hidden" name="id" value="${item.id}"></p>
            <p>Name: <input type="text" name="name" value="${item.route.name}" class="form-control"/></p>
            <p>Cost: <input type="number" name="cost" class="form-control" value="${item.route.cost}" required="required"/></p>
            <p>Duration: <input type="number" name="duration" class="form-control" value="${item.route.duration}" required="required"/></p>
            <p>Countries:
                <select name="countries" class="form-select">
                    <#list countries as country>
                        <#if "${item.country.name}" == country>
                            <option value="${country}" selected>${country}</option>
                        <#else>
                            <option value="${country}">${country}</option>
                        </#if>
                    </#list>
                </select>
            </p>
            <p>Clients:
                <select name="clients" class="form-select">
                    <#list clients as client>
                        <#if "${item.client.firstName}_${item.client.lastName}_${item.client.patronymic}" == client>
                            <option value="${client}" selected>${client}</option>
                        <#else>
                            <option value="${client}">${client}</option>
                        </#if>
                    </#list>
                </select>
            </p>
            <p>Hotel:
                <select name="hotel" class="form-select">
                    <#list hotels as hotel>
                        <#if "${item.hotel}" == hotel>
                            <option value="${hotel}" selected>${hotel}</option>
                        <#else>
                            <option value="${hotel}">${hotel}</option>
                        </#if>
                    </#list>
                </select>
            </p>


            <p>Description: <input type="text" name="description" value="${item.route.description}" class="form-control"/></p>
            <p><input type="submit" value="Submit" class="btn btn-primary"/>
                <input type="reset" value="Reset" class="btn btn-secondary"/>
        </form>
    </fieldset>
    </div>
            </div>
            </div>

</body>
</html>