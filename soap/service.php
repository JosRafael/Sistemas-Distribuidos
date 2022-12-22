<?php
    require "nusoap.php";
    require "function.php";
    $server = new nusoap_server();
    $server->configureWSDL("consulta", "urn:consulta");
    $server->register(
        "preco",
        array("nome"=>"xsd:string"),
        array("nome"=>"xsd:float")
    );
    $server->service(file_get_contents("php://input"));
?>