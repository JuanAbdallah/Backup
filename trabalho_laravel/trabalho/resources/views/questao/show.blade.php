{{--@extends('layout.app')--}}

{{--@section('content')--}}
{{--    <div class="container">--}}
{{--        <h2>Nome: {{$teste->nome}}</h2>--}}
{{--        <h2>Média: {{$teste->notaAprovacao}}</h2>--}}
{{--    </div>--}}

{{--    <table class="table table-striped">--}}
{{--        <thead>--}}
{{--        <tr>--}}
{{--            <th>#</th>--}}
{{--            <th>Enunciado</th>--}}
{{--            <th>Valor</th>--}}
{{--            <th>Alternativa A</th>--}}
{{--            <th>Alternativa B</th>--}}
{{--            <th>Alternativa C</th>--}}
{{--            <th>Alternativa D</th>--}}
{{--            <th>Alternativa E</th>--}}
{{--            <th>Alternativa Certa</th>--}}
{{--            <th># Teste</th>--}}
{{--            <th>AÇÕES</th>--}}
{{--        </tr>--}}
{{--        </thead>--}}
{{--        <tbody>--}}
{{--        @forelse($questoes as $questao)--}}
{{--            <tr>--}}
{{--                <td>{{ $questao->id }}</td>--}}
{{--                <td>{{ $questao->Enunciado }}</td>--}}
{{--                <td>{{ $questao->valorQuest }}</td>--}}
{{--                <td>{{ $questao->A }}</td>--}}
{{--                <td>{{ $questao->B }}</td>--}}
{{--                <td>{{ $questao->C }}</td>--}}
{{--                <td>{{ $questao->D }}</td>--}}
{{--                <td>{{ $questao->E }}</td>--}}
{{--                <td>{{ $questao->respCorreta }}</td>--}}
{{--                <td>{{ $questao->teste->id }}</td>--}}
{{--                <td>--}}
{{--                    <a href="{{ route('questao.edit', ['questao' => $questao->id]) }}" class="btn btn-sm btn-primary w-50 mb-2">Editar</a><br>--}}
{{--                    <form action="{{ route('questao.destroy', ['questao' => $questao->id]) }}" method="post">--}}
{{--                        @csrf--}}
{{--                        @method('DELETE')--}}
{{--                        <input type="submit" value="Remover" class="btn btn-sm btn-danger w-50 mb-2">--}}
{{--                    </form>--}}
{{--                </td>--}}
{{--            </tr>--}}
{{--        @empty--}}
{{--            <tr>--}}
{{--                <td colspan="11">Nenhum registro cadastrado!</td>--}}
{{--            </tr>--}}
{{--        @endforelse--}}
{{--        </tbody>--}}
{{--    </table>--}}
{{--    <a href="{{ route('criarQuestao', ['teste' => $questao->teste->id]) }}" class="btn btn-sm btn-success w-50 mb-2">Criar Questão</a><br>--}}
{{--@endsection--}}

@extends('layout.app')

@section('content')
    <div class="container">
        <h2>Teste: {{$teste->nome}}</h2>
        <h2>Nota Mínima para Aprovação: {{$teste->notaAprovacao}}</h2>

        <hr>

        @foreach($questoes as $questao)
            <div class="questao">
                <h4>Questão {{ $loop->iteration }}</h4>
                <p><strong>Enunciado:</strong> {{ $questao->Enunciado }}</p>
                <div class="opcoes">
                    <div class="opcao">
                        <input type="radio" name="questao{{ $questao->id }}" value="A" id="questao{{ $questao->id }}A">
                        <label for="questao{{ $questao->id }}A">A) {{ $questao->A }}</label>
                    </div>
                    <div class="opcao">
                        <input type="radio" name="questao{{ $questao->id }}" value="B" id="questao{{ $questao->id }}B">
                        <label for="questao{{ $questao->id }}B">B) {{ $questao->B }}</label>
                    </div>
                    <div class="opcao">
                        <input type="radio" name="questao{{ $questao->id }}" value="C" id="questao{{ $questao->id }}C">
                        <label for="questao{{ $questao->id }}C">C) {{ $questao->C }}</label>
                    </div>
                    <div class="opcao">
                        <input type="radio" name="questao{{ $questao->id }}" value="D" id="questao{{ $questao->id }}D">
                        <label for="questao{{ $questao->id }}D">D) {{ $questao->D }}</label>
                    </div>
                    <div class="opcao">
                        <input type="radio" name="questao{{ $questao->id }}" value="E" id="questao{{ $questao->id }}E">
                        <label for="questao{{ $questao->id }}E">E) {{ $questao->E }}</label>
                    </div>
                </div>
            </div>
            <hr>
        @endforeach

        <a href="{{ route('criarQuestao', ['teste' => $teste->id]) }}" class="btn btn-sm btn-success">Criar Nova Questão</a>
    </div>
@endsection

