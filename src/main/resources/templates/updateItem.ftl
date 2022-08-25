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
            <li><a href="/ui/v1/countries/">country</a></li>
            <li><a href="/ui/v1/clients/">clients</a></li>
            <li><a href="/ui/v1/routes/">routes</a></li>
            <li><a href="/ui/v1/vouchers/">vouchers</a></li>
            <li><a href="/ui/v1/umlDiagram/">uml diagram</a></li>
        </ul>
    </div>

    <div id='center' class="main center">
        <h3 align="center">Change client "${item.name}"</h3>
        <div style="display: flex; margin: 0" >
            <div style="min-height: 10em; display: table-cell; margin-left: auto;margin-right: auto; width: 25em;" class="shadow p-3 mb-5 bg-body rounded" >
    <fieldset>
        <form action="" method="post">
            <p><input type="hidden" name="id" value="${item.id}"></p>
            <p>Name: <input type="text" name="name" value="${item.name}" class="form-control"/></p>
            <p>Is Visa: <input type="checkbox" name="visa" value="${item.visa?string('yes', 'no')}" class="form-check-input"/></p>
            <p>Level Tourism: <input type="number" required="required" name="levelTourism" value="${item.levelTourism}" class="form-control"/></p>
            <p>Climate Types:
                <select name="climateTypes" class="form-select">
                    <#list enums as enum>
                        <#if "${item.climateTypes}" == enum>
                        <option value="${enum}" selected>${enum}</option>
                        <#else>
                        <option value="${enum}">${enum}</option>
                        </#if>
                    </#list>
                </select>
            </p>

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