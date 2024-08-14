@extends('layout.app')

@section('content')

<div class="container mt-5">
    <h1>Criando um teste:</h1><br>
    <form action="{{route('teste.store')}}" method="post" class="form-group">
        @csrf
        <div class="form-group">
            <label for="nome">Nome:</label>
            <input type="text" name="nome" id="nome" class="form-control" value="{{old('nome')}}">
        </div>
        <div class="form-group">
            <label for="aprovacao">Pontuação mínima para aprovação:</label>
            <input type="text" name="notaAprovacao" id="aprovacao" class="form-control" value="{{old('aprovacao')}}">
        </div>
        <button type="submit" name="enviar" class="btn btn-primary">Enviar</button>
    </form>
</div>

@endsection
