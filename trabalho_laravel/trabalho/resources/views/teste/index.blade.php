@extends('layout.app')

@section('content')

    <table class="table table-striped">
        <thead>
        <tr>
            <th>#</th>
            <th>Autor</th>
            <th>Nome</th>
            <th>Nota para Aprovação</th>
            <th>Criado em</th>
            <th>Ações</th>
        </tr>
        </thead>
        <tbody>
        @forelse($testes as $teste)
            <tr>
                <td>{{$teste->id}}</td>
                <td>{{$teste->user->name}}</td>
                <td>{{$teste->nome}}</td>
                <td>{{$teste->notaAprovacao}}</td>
                <td>{{date('d/m/Y H:i:s', strtotime($teste->created_at))}}</td>
                <td>


                    <a href="{{route('teste.edit',['teste' => $teste->id])}}" class="btn btn-sm btn-primary w-50 mb-2">Editar</a><br>
                    <a href="{{route('criarQuestao', ['teste' => $teste->id])}}" class="btn btn-sm btn-success w-50 mb-2">Criar Questao</a><br>
                    <a href="{{route('indexQuestao', ['teste' => $teste->id])}}" class="btn btn-sm btn-primary w-50 mb-2">Ver Questões</a>
                    <a href="{{route('showQuestao', ['teste' => $teste->id])}}" class="btn btn-sm btn-primary w-50 mb-2">Fazer Teste</a><br>

                    <form action="{{route('teste.destroy',['teste' => $teste->id])}}" method="post">
                        @csrf

                        @method('DELETE')

                        <input type="submit" value="Remover" class="btn btn-sm btn-danger w-50 mb-2">

                    </form>

                </td>
            </tr>
        @empty
            <tr>
                <td colspan="5">Nenhum registro cadastrado!</td>
            </tr>
        @endforelse
        </tbody>
    </table>
    <a class="btn btn-primary" href="{{route('teste.create')}}">Criar teste!</a>
@endsection
