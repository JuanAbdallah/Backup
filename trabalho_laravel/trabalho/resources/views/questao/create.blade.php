<!doctype html>
@extends('layout.app')

@section('content')
    <div class="container mt-5">
        <h1>Criando uma questão: </h1>
        <form action="{{route('storeQuestao', ['teste' => $teste])}}" method="post" class="form-group">
            @csrf
            <label>Enunciado: </label>
            <textarea name="Enunciado" id="enunciado" cols="30" rows="3" class="form-control"></textarea><br>
            <label for="a">Reaspota A: </label>
            <input type="text" name="A" id="a" class="form-control"><br>
            <label for="b">Reaspota B: </label>
            <input type="text" name="B" id="b" class="form-control"><br>
            <label for="c">Reaspota C: </label>
            <input type="text" name="C" id="c" class="form-control"><br>
            <label for="d">Reaspota D: </label>
            <input type="text" name="D" id="d" class="form-control"><br>
            <label for="e">Reaspota E: </label>
            <input type="text" name="E" id="e" class="form-control"><br>
            <label for="certo">Resposta certa: </label>
            <select name="respCorreta" id="certo" class="form-control " >
                <option value="a">A</option>
                <option value="b">B</option>
                <option value="c">C</option>
                <option value="d">D</option>
                <option value="e">E</option>
            </select><br>
            <label for="valorQuest">Valor questão: </label>
            <input type="text" name="valorQuest" class="form-control">
            <button type="submit" name="enviar" class="btn btn-primary">Enviar</button>
        </form>
    </div>
@endsection
