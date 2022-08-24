<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <#include "less.css">
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
            <li><a href="/ui/v1/countries/" target="_blank">country</a></li>
            <li><a href="https://twitter.com/plavookac" target="_blank">add client</a></li>
            <li><a href="https://www.youtube.com/channel/UCDfZM0IK6RBgud8HYGFXAJg" target="_blank">YouTube</a></li>
            <li><a href="https://www.linkedin.com/in/plavookac/" target="_blank">Linkedin</a></li>
        </ul>
    </div>
    <div id='center' class="main center">
        <div style=" vertical-align: center;">
            <div style="min-height: 10em; display: table-cell;">
    <fieldset>
        <form action="" method="post">
            <p><input type="hidden" name="id" value="${item.id}"></p>
            <p>Name: <input type="text" name="name" value="${item.name}"/></p>
            <p>Is Visa: <input type="checkbox" name="visa" value="${item.visa?string('yes', 'no')}"/></p>
            <p>Level Tourism: <input type="number" required="required" name="levelTourism" value="${item.levelTourism}"/></p>
            <p>Climate Types:
                <select name="climateTypes">
                    <#list enums as enum>
                        <#if "${item.climateTypes}" == enum>
                        <option value="${enum}" selected>${enum}</option>
                        <#else>
                        <option value="${enum}">${enum}</option>
                        </#if>
                    </#list>
                </select>
            </p>

            <p>Description: <input type="text" name="description" value="${item.description}"/></p>
            <p><input type="submit" value="Submit" /><input type="reset" value="Reset" />
        </form>
    </fieldset>
    </div>
            </div>
            </div>

</body>
</html>