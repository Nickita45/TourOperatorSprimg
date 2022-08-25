<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Voucherlog update</title>
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
        <h3 align="center">Change voucherlog "${item.voucher.name}"</h3>
        <div style="display: flex; margin: 0" >
            <div style="min-height: 10em; display: table-cell; margin-left: auto;margin-right: auto; width: 25em;" class="shadow p-3 mb-5 bg-body rounded" >
    <fieldset>
        <form action="" method="post">
            <p><input type="hidden" name="id" value="${item.id}"></p>
            <p>Name: <input type="text" name="name" value="${item.voucher.name}" class="form-control"/></p>
            <p>Clients:
                <select name="clients" class="form-select">
                    <#list clients as client>
                        <#if "${item.client.name}" == client>
                            <option value="${client}" selected>${client}</option>
                        <#else>
                            <option value="${client}">${client}</option>
                        </#if>
                    </#list>
                </select>
            </p>
            <p>Routes:
                <select name="routes" class="form-select">
                    <#list routes as route>
                        <#if "${route.client.name}" == item.client.name>
                        <option selected value="${route.country.name}_LevelTourism:${route.country.levelTourism}_Cost:${route.route.cost}_Climate:${route.country.climateTypes}_Duration:${route.route.duration}">
                            ${route.country.name}_LevelTourism:${route.country.levelTourism}_Cost:${route.route.cost}_Climate:${route.country.climateTypes}_Duration:${route.route.duration}
                        </option>
                        <#else>
                            <option value="${route.country.name}_LevelTourism:${route.country.levelTourism}_Cost:${route.route.cost}_Climate:${route.country.climateTypes}_Duration:${route.route.duration}">
                                ${route.country.name}_LevelTourism:${route.country.levelTourism}_Cost:${route.route.cost}_Climate:${route.country.climateTypes}_Duration:${route.route.duration}
                            </option>
                        </#if>
                    </#list>
                </select>
            </p>

            <p>Number of vouchers: <input type="number" required="required" name="number" class="form-control" value="${item.voucher.totalCost}"/></p>


            <p>Description: <input type="text" name="description" value="${item.voucher.description}" class="form-control"/></p>
            <p><input type="submit" value="Submit" class="btn btn-primary"/>
                <input type="reset" value="Reset" class="btn btn-secondary"/>
        </form>
    </fieldset>
    </div>
            </div>
            </div>

</body>
</html>