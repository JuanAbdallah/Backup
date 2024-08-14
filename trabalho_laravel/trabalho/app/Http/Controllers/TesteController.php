<?php

namespace App\Http\Controllers;

use App\Models\Teste;
use App\Models\User;
use Illuminate\Http\Request;

class TesteController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        $user = auth()->user();
        $testes = Teste::where('user_id', $user->id)->get();
        return view('teste.index', compact('testes'));
    }

    /**
     * Show the form for creating a new resource.
     */
    public function create()
    {
        return view('teste.create');
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        $data = $request->all();
        $user = auth()->user();

        $teste = $user->teste()->create($data);


        return redirect()->route('teste.index');
    }


    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(Teste $teste)
    {
        return view('teste.update', compact('teste'));
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, Teste $teste)
    {
        $data = $request->all();
        $teste->update($data);

        return redirect()->route('teste.index');
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(Teste $teste)
    {
        $teste->delete();

        return redirect()->route('teste.index');
    }
}
