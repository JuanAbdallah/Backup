@extends('layout.app')

@section('content')

<div class="container mt-5">
    <h1>Alterando um teste:</h1><br>
    <form action="{{route('teste.update',['teste' => $teste->id])}}" method="post" class="form-group">
        @csrf
        @method("PUT")
        <div class="form-group">
            <label for="nome">Nome:</label>
            <input type="text" name="nome" id="nome" class="form-control" value="{{$teste->nome}}">
        </div>
        <div class="form-group">
            <label for="aprovacao">Pontuação mínima para aprovação:</label>
            <input type="text" name="notaAprovacao" id="aprovacao" class="form-control" value="{{$teste->notaAprovacao}}">
        </div>
        <button type="submit" name="enviar" class="btn btn-primary">Alterar</button>
    </form>

    <form action="{{route('teste.destroy', ['teste' => $teste->id])}}" method="post" class="form-group mt-3">
        @csrf
        @method('DELETE')
        <button type="submit" class="btn btn-danger">Deletar</button>
    </form>

</div>

@endsection
