<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Teste extends Model
{
    use HasFactory;

    protected $fillable = [
        'nome',
        'notaAprovacao',
        'user_id'
    ];

    function user(){
        return $this->belongsTo(User::class);
    }

    function question(){
        return $this->hasMany(Question::class);
    }
}
