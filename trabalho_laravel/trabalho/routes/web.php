<?php

use App\Http\Controllers\ProfileController;
use Illuminate\Support\Facades\Route;
use \App\Http\Controllers\QuestionController;
use \App\Http\Controllers\TesteController;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "web" middleware group. Make something great!
|
*/
Route::middleware('auth')->group(function () {
    Route::get('/profile', [ProfileController::class, 'edit'])->name('profile.edit');
    Route::patch('/profile', [ProfileController::class, 'update'])->name('profile.update');
    Route::delete('/profile', [ProfileController::class, 'destroy'])->name('profile.destroy');
});

require __DIR__.'/auth.php';

Route::resource('/teste', TesteController::class);
Route::resource('/questao', QuestionController::class);

Route::get('/',function (){
    return view('home');
})->name('home');;
Route::get('/home', function(){
    return redirect()->route('home');
});


Route::get('/questao/{questao}/edit', [QuestionController::class, 'edit'])->name('questao.edit');
//
Route::get('/questao/create/{teste}', [QuestionController::class, 'create'])->name('criarQuestao');
Route::post('/questao/store/{teste}', [QuestionController::class, 'store'])->name('storeQuestao');

Route::get('questao/show/{teste}', [QuestionController::class, 'show'])->name('showQuestao');
Route::get('questao/index/{teste}', [QuestionController::class, 'index'])->name('indexQuestao');

