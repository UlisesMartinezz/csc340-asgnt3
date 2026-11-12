<#macro page title active="">

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>${title} | Naruto Character Gallery</title>

    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
        rel="stylesheet">

    <link rel="stylesheet" href="/css/styles.css">
</head>

<body>


    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">

        <div class="container">

            <a class="navbar-brand" href="/">
                Naruto Characters
            </a>

            <div>
                <a href="/" class="nav-link d-inline text-white">Home</a>

                <a href="/about" class="nav-link d-inline text-white"> About </a>

                <a href="/characters/new" class="nav-link d-inline text-white"> Add Character </a>
            </div>

        </div>

    </nav>

<main class="container">
    <#if message??>
        <div class="alert"> ${message}</div>
    </#if>

    <#nested>
</main>

<footer>
    &copy; 2026 Naruto Character Gallery. Made for school assignment
</footer>

</body>

</html>
</#macro>