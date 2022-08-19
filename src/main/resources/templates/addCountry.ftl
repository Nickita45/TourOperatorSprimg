<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Country</title>
</head>
<body>
<fieldset>
    <form>
        <form action="#" action="@{/greeting}" object="${greeting}" method="post">
            <p>Id: <input type="text" field="*{id}" /></p>
            <p>Name: <input type="text" field="*{name}" /></p>
            <p><input type="submit" value="Submit" /><input type="reset" value="Reset" />
    </form>
</fieldset>


</body>
</html>