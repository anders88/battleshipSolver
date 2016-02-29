using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Web.Script.Serialization;

namespace FtaSolver
{
    public class Solver
    {
        // REPLACE WITH SERVER ADDRESS
        private const String ApplicationUrl = "http://xxx.herokuapp.com/";
        // REPLACE WITH YOUR PLAYER ID
        private const String PlayerId = "0125442";

        private static readonly WebClient Client = new WebClient();
   

        public static void Main()
        {
            var answerString = "[[0,0],[1,0]]";
            Console.WriteLine("Answering: " + answerString);
            var response = Client.UploadString(ApplicationUrl + "game/shoot/" + PlayerId, answerString);
            Console.WriteLine("Response from server: " + response);
            
            Console.WriteLine("Press enter");
            Console.In.Read();
        }
    }

   
}