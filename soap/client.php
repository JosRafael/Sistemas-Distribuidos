<?php
    require "nusoap.php";

    $client = new nusoap_client("http://localhost//soap/service.php?wsdl");
    $nome_do_livro = "IHC";
    $preco = $client-> call("preco", array('nome'=>"$nome_do_livro"))
?>
<html>
    <body>
        <h1 class="margin-top: 100px;">
            Preco do livro <?php echo $nome_do_livro; ":" .$preco;?>;
        </h1>
    </body>
</html>