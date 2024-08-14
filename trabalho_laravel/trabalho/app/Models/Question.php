<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Question extends Model
{
    use HasFactory;

    protected $fillable = [
        "Enunciado",
        "A",
        'B',
        'C',
        'D',
        'E',
        'respCorreta',
        'valorQuest',
        'teste_id'
    ];

    function teste(){
        return $this->belongsTo(Teste::class);
    }
}
