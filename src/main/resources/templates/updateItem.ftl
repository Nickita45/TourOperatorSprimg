<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div>

    <fieldset>
        <form action="/ui/v1/countries/" method="post">
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
</body>
</html>