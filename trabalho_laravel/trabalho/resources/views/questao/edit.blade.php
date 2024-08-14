@extends('layout.app')

@section('content')
    <h1>Editando Questões do Teste: {{ $questao->teste->nome }}</h1>

    @if (session('success'))
        <div class="alert alert-success">
            {{ session('success') }}
        </div>
    @endif

    <form action="{{ route('questao.update', ['questao' => $questao->id]) }}" method="post">
        @csrf
        @method('PUT')

        <div class="form-group">
            <label for="enunciado">Enunciado</label>
            <textarea class="form-control" name="Enunciado">{{ $questao->Enunciado }}</textarea>
        </div>
        <div class="form-group">
            <label for="a">Alternativa A</label>
            <input type="text" class="form-control" name="A" value="{{ $questao->A }}">
        </div>
        <div class="form-group">
            <label for="b">Alternativa B</label>
            <input type="text" class="form-control" name="B" value="{{ $questao->B }}">
        </div>
        <div class="form-group">
            <label for="c">Alternativa C</label>
            <input type="text" class="form-control" name="C" value="{{ $questao->C }}">
        </div>
        <div class="form-group">
            <label for="d">Alternativa D</label>
            <input type="text" class="form-control" name="D" value="{{ $questao->D }}">
        </div>
        <div class="form-group">
            <label for="e">Alternativa E</label>
            <input type="text" class="form-control"name="E" value="{{ $questao->E }}">
        </div>
        <div class="form-group">
            <label for="respCorreta">Resposta Correta</label>
            <input type="text" class="form-control" name="respCorreta" value="{{ $questao->respCorreta }}">
        </div>
        <div class="form-group">
            <label for="valorQuest">Valor da Questão</label>
            <input type="number" class="form-control" name="valorQuest" value="{{ $questao->valorQuest }}">
        </div>

        <button type="submit" class="btn btn-primary">Salvar Questão</button>
    </form>

@endsection
