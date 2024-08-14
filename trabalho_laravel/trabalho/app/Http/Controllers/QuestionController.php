<?php

namespace App\Http\Controllers;

use App\Models\Teste;
use App\Models\Question;
use Illuminate\Http\Request;

class QuestionController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index(Teste $teste)
    {

        $questoes = Question::where('teste_id', $teste->id)->get();
//        dd($questoes);
        return view('questao.index', compact('questoes'));
    }

    /**
     * Show the form for creating a new resource.
     */
    public function create(Teste $teste)
    {
        return view('questao.create', compact('teste'));
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request, Teste $teste)
    {
        $data = $request->all();

        $teste->question()->create($data);

        return redirect()->route('home');
    }

    /**
     * Display the specified resource.
     */
    public function show(Teste $teste)
    {
        $questoes = Question::where('teste_id', $teste->id)->get();
//        dd($questoes);
        return view('questao.show', compact('questoes'), compact('teste'));
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(Question $questao)
    {
        return view('questao.edit', compact('questao'));
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request,Question $questao)
    {

        $data = $request->all();
        $questao->update($data);
        return redirect()->route('home');
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(Question $questao)
    {
        $questao->delete();

        return redirect()->route('teste.index');
    }
}
