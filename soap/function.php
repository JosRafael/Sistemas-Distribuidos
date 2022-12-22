<?php 
    function preco($nome){
        $livros = Array(
            'Programação' => 120.00, 'Redes' => 99.00, 'IHC' => 89.00
        );
        foreach($livros as $key =>  $value){
            if($nome == $key){
                $preco = $value;
            }
            return $preco;
        }
    }
?>