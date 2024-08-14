@extends('layout.app')

@section('content')

    <table class="table table-striped">
        <thead>
        <tr>
            <th>#</th>
            <th>Enunciado</th>
            <th>Valor</th>
            <th>Alternativa A</th>
            <th>Alternativa B</th>
            <th>Alternativa C</th>
            <th>Alternativa D</th>
            <th>Alternativa E</th>
            <th>Alternativa Certa</th>
            <th># Teste</th>
            <th>AÇÕES</th>
        </tr>
        </thead>
        <tbody>
        @forelse($questoes as $questao)
            <tr>
                <td>{{ $questao->id }}</td>
                <td>{{ $questao->Enunciado }}</td>
                <td>{{ $questao->valorQuest }}</td>
                <td>{{ $questao->A }}</td>
                <td>{{ $questao->B }}</td>
                <td>{{ $questao->C }}</td>
                <td>{{ $questao->D }}</td>
                <td>{{ $questao->E }}</td>
                <td>{{ $questao->respCorreta }}</td>
                <td>{{ $questao->teste->id }}</td>
                <td>
                    <a href="{{ route('questao.edit', ['questao' => $questao->id]) }}" class="btn btn-sm btn-primary w-50 mb-2">Editar</a><br>
                    <form action="{{ route('questao.destroy', ['questao' => $questao->id]) }}" method="post">
                        @csrf
                        @method('DELETE')
                        <input type="submit" value="Remover" class="btn btn-sm btn-danger w-50 mb-2">
                    </form>
                </td>
            </tr>
        @empty
            <tr>
                <td colspan="11">Nenhum registro cadastrado!</td>
            </tr>
        @endforelse
        </tbody>
    </table>
    <a href="{{ route('criarQuestao', ['teste' => $questao->teste->id]) }}" class="btn btn-sm btn-success w-50 mb-2">Criar Questão</a><br>
@endsection
