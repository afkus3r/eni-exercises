<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Reviews</title>
</head>
<body>
<main>
    <?php
    function getRestaurantList()
    {
        // DB Connection
        try {
            $dsn = 'mysql:host=localhost;dbname=restaurant';
            $options = [PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8"];
            $pdo = new PDO($dsn, 'root', '', $options);
            $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        } catch (PDOException $e) {
            $msg = 'PDO ERROR in ' . $e->getFile() . ' : ' . $e->getLine() . ' : ' . $e->getMessage();
            die($msg);
        }

        // SQL Instructions
        $SELECT_ALL_RESAURANTS_NAME = 'SELECT name FROM restaurants';
        $prep = $pdo->prepare($SELECT_ALL_RESAURANTS_NAME);
        $prep->execute();
        return $prep->fetch();
    }

    function getCity($name)
    {
        // DB Connection
        try {
            $dsn = 'mysql:host=localhost;dbname=restaurant';
            $options = [PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8"];
            $pdo = new PDO($dsn, 'root', '', $options);
            $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        } catch (PDOException $e) {
            $msg = 'PDO ERROR in ' . $e->getFile() . ' : ' . $e->getLine() . ' : ' . $e->getMessage();
            die($msg);
        }

        // SQL Instructions
        $SELECT_CITY = 'SELECT city FROM restaurants WHERE name = :name';
        $prep = $pdo->prepare($SELECT_CITY);
        $prep->bindValue(':name', $name);
        $prep->execute();
        $city = $prep->fetch();
        return implode('', $city);
    }

    function getDescription($name)
    {
        // DB Connection
        try {
            $dsn = 'mysql:host=localhost;dbname=restaurant';
            $options = [PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8"];
            $pdo = new PDO($dsn, 'root', '', $options);
            $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        } catch (PDOException $e) {
            $msg = 'PDO ERROR in ' . $e->getFile() . ' : ' . $e->getLine() . ' : ' . $e->getMessage();
            die($msg);
        }

        // SQL Instructions
        $SELECT_DESCRIPTION = 'SELECT description FROM restaurants WHERE name = :name';
        $prep = $pdo->prepare($SELECT_DESCRIPTION);
        $prep->bindValue(':name', $name);
        $prep->execute();
        $description = $prep->fetch();
        return implode('', $description);
    }

    ?>
</main>
</body>
</html>


