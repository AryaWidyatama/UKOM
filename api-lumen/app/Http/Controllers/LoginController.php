<?php

namespace App\Http\Controllers;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Str;
use Illuminate\Support\Facades\Hash;

class LoginController extends Controller
{
  public function index()
  {
   $data = User::where('pelanggan')->get();
   return response()->json($data);
  }
    public function register(Request $request)
    {
      $data = [
        'email' => $request->input('email'),
        'password' => $request->input('password') ,
        'level' => $request->input('level'),
        'api_token' => '123456',
        'status' => '1',
       'relasi' => $request->input('relasi'),
      ];

      User::create($data);
      $datauser = [
        'message' => 'succes',
        'status' => 202,
        'pesan' => 'LoginBerhaasil',
        'data' => $data
      ];
     

      return response()->json($datauser);
    }

    public function login(Request $request)
    {
      
      $email = $request->input('email');
      $password = $request->input('password');

      $user = User::where(['password' => $password,
      'email' => $email])->first();

      if (isset($user)) {
        if ($user->status === 1) {
          if (($password && $email)) {
          
   
            // $user->update([
            //     'api_token' => $token
            // ]);
   
            return response()->json([
              'message' => 'succes',
              'status' => 202,
              'pesan' => 'LoginBerhaasil',
              'data' => $user
              
            ]);
         }else{
           return response()->json([
            'message' => 'succes',
            'status' => 202,
            'pesan' => 'Gagal',
            'data' => ''
            ]);
         }
        }else{
          return response()->json([
            'message' => 'succes',
            'status' => 202,
            'pesan' => 'Gagal',
            'data' => ''
           ]);
        }
      }else{
        return response()->json([
          'message' => 'succes',
          'status' => 202,
          'pesan' => 'Gagal',
          'data' => ''
       ]);
      }

     

     
    }

    public function loginforgetpass(Request $request)
    {
      
      $email = $request->input('email');
  

      $user = User::where(['email' => $email])->first();

      if (isset($user)) {
        if ($user->status === 1) {
          if (($email)) {
          
   
            // $user->update([
            //     'api_token' => $token
            // ]);
   
            return response()->json([
              'message' => 'succes',
              'status' => 202,
              'pesan' => 'LoginBerhaasil',
              'data' => $user
              
            ]);
         }else{
           return response()->json([
            'message' => 'succes',
            'status' => 202,
            'pesan' => 'Gagal',
            'data' => ''
            ]);
         }
        }else{
          return response()->json([
            'message' => 'succes',
            'status' => 202,
            'pesan' => 'Gagal',
            'data' => ''
           ]);
        }
      }else{
        return response()->json([
          'message' => 'succes',
          'status' => 202,
          'pesan' => 'Gagal',
          'data' => ''
       ]);
      }

     

     
    }

    public function update(Request $request, $id)
    {
   

        $data = [
          'password' => $request->input('password'),
          'email' => $request->input('email')
       
      ];

      $user =  User::where('id',$id)->update($data);
        if ($user) {
            return response()->json([
                'pesan' => "Data sudah di ubah !"
            ]);
           }
    }
}
