package com.meu.verso.jeiel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.app.NotificationManager;
import android.app.NotificationChannel;

import android.app.PendingIntent;
import androidx.core.app.NotificationCompat;

import java.util.Random;

public class NotificationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String[] versiculos = {
    "O Senhor é o meu pastor; nada me faltará. (Salmos 23:1)",
    "Tudo posso naquele que me fortalece. (Filipenses 4:13)",
    "Porque Deus amou o mundo de tal maneira que deu o seu Filho unigênito, para que todo aquele que nele crê não pereça, mas tenha a vida eterna. (João 3:16)",
    "Entrega o teu caminho ao Senhor; confia nele, e o mais ele fará. (Salmos 37:5)",
    "O choro pode durar uma noite, mas a alegria vem pela manhã. (Salmos 30:5)",
    "Se Deus é por nós, quem será contra nós? (Romanos 8:31)",
    "Confia no Senhor de todo o teu coração e não te estribes no teu próprio entendimento. (Provérbios 3:5)",
    "Clama a mim, e responder-te-ei e anunciar-te-ei coisas grandes e firmes que não sabes. (Jeremias 33:3)",
    "Aquietai-vos, e sabei que eu sou Deus. (Salmos 46:10)",
    "Buscai primeiro o Reino de Deus e a sua justiça, e todas estas coisas vos serão acrescentadas. (Mateus 6:33)",
    "O Senhor é a minha luz e a minha salvação; a quem temerei? (Salmos 27:1)",
    "Bem-aventurados os que choram, porque serão consolados. (Mateus 5:4)",
    "Deleita-te também no Senhor, e ele te concederá os desejos do teu coração. (Salmos 37:4)",
    "O Senhor guarda a todos os que o amam, mas todos os ímpios ele destruirá. (Salmos 145:20)",
    "Não temas, porque eu sou contigo; não te assombres, porque eu sou o teu Deus; eu te fortaleço, e te ajudo, e te sustento com a destra da minha justiça. (Isaías 41:10)",
    "Lança o teu cuidado sobre o Senhor, e ele te susterá; jamais permitirá que o justo seja abalado. (Salmos 55:22)",
    "Sede fortes e corajosos; não temais, nem vos espanteis diante deles; porque o Senhor vosso Deus é quem vai convosco. (Deuteronômio 31:6)",
    "O coração do homem planeja o seu caminho, mas o Senhor lhe dirige os passos. (Provérbios 16:9)",
    "O Senhor é bom, uma fortaleza no dia da angústia; conhece os que confiam nele. (Naum 1:7)",
    "Cria em mim, ó Deus, um coração puro, e renova dentro de mim um espírito reto. (Salmos 51:10)",
    "O amor é paciente, o amor é bondoso; não inveja, não se vangloria, não se orgulha. (1 Coríntios 13:4)",
    "Guardarei a tua palavra no meu coração para não pecar contra ti. (Salmos 119:11)",
    "O Senhor te abençoe e te guarde; faça resplandecer o seu rosto sobre ti, e tenha misericórdia de ti. (Números 6:24-25)",
    "A resposta branda desvia o furor, mas a palavra dura suscita a ira. (Provérbios 15:1)",
    "Em tudo dai graças, porque esta é a vontade de Deus em Cristo Jesus para convosco. (1 Tessalonicenses 5:18)",
    "Não andeis ansiosos por coisa alguma; antes, em tudo sejam os vossos pedidos conhecidos diante de Deus pela oração e súplica com ação de graças. (Filipenses 4:6)",
    "Aquele que habita no esconderijo do Altíssimo, à sombra do Onipotente descansará. (Salmos 91:1)",
    "O Senhor pelejará por vós, e vós vos calareis. (Êxodo 14:14)",
    "Bem-aventurados os que confiam no Senhor e cuja confiança é o Senhor. (Jeremias 17:7)",
    "A fé é a certeza daquilo que esperamos e a prova das coisas que não vemos. (Hebreus 11:1)",
    "O Senhor é misericordioso e compassivo, longânimo e grande em benignidade. (Salmos 103:8)",
    "Porque sou eu que conheço os planos que tenho para vós, diz o Senhor, planos de bem e não de mal, para vos dar o futuro e a esperança. (Jeremias 29:11)",
    "Vinde a mim, todos os que estais cansados e oprimidos, e eu vos aliviarei. (Mateus 11:28)",
    "O Senhor é justo em todos os seus caminhos e bondoso em todas as suas obras. (Salmos 145:17)",
    "O Senhor é o meu rochedo, a minha fortaleza e o meu libertador. (Salmos 18:2)",
    "Eu vos dou um novo mandamento: que vos ameis uns aos outros; como eu vos amei. (João 13:34)",
    "E conhecereis a verdade, e a verdade vos libertará. (João 8:32)",
    "Não temas, porque eu te remi; chamei-te pelo teu nome; tu és meu. (Isaías 43:1)",
    "O Senhor é a minha força e o meu cântico; ele se tornou a minha salvação. (Êxodo 15:2)",
    "Sonda-me, ó Deus, e conhece o meu coração; prova-me e conhece os meus pensamentos. (Salmos 139:23)",
    "Cantai ao Senhor um cântico novo; cantai ao Senhor, todas as terras. (Salmos 96:1)",
    "Confia no Senhor perpetuamente, porque o Senhor Deus é uma rocha eterna. (Isaías 26:4)",
    "Louvai ao Senhor, porque ele é bom; porque a sua benignidade dura para sempre. (Salmos 136:1)",
    "O Senhor sustenta todos os que caem e levanta todos os abatidos. (Salmos 145:14)",
    "Mas os que esperam no Senhor renovarão as suas forças; subirão com asas como águias. (Isaías 40:31)",
    "Clama ao Senhor, e ele te ouvirá, e todos os teus inimigos serão envergonhados. (Salmos 34:17)",
    "O Senhor é o meu refúgio e a minha fortaleza, meu Deus, em quem confio. (Salmos 91:2)",
    "Alegrai-vos sempre no Senhor; outra vez digo: alegrai-vos. (Filipenses 4:4)",
    "Entrega o teu caminho ao Senhor; confia nele, e ele agirá. (Salmos 37:5)",
    "Esforça-te, e tem bom ânimo; não temas, nem te espantes, porque o Senhor teu Deus é contigo. (Josué 1:9)",
    "O Senhor é bom para todos, e as suas misericórdias estão sobre todas as suas obras. (Salmos 145:9)",
    "Honra ao Senhor com os teus bens, e com as primícias de toda a tua renda. (Provérbios 3:9)"
};

        Random random = new Random();
        String message = versiculos[random.nextInt(versiculos.length)];

        String channelId = "versiculo_channel";

        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    channelId,
                    "Versículos Diários",
                    NotificationManager.IMPORTANCE_HIGH
            );
            notificationManager.createNotificationChannel(channel);
        }

        Intent notifyIntent = new Intent(context, MainActivity.class);
        notifyIntent.putExtra("versiculo", message);
        notifyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        
        PendingIntent pendingIntent = PendingIntent.getActivity(
                context, 0, notifyIntent, 
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
        );

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context, channelId)
                        .setSmallIcon(R.drawable.logo_app)
                        .setContentTitle("Versículo do dia")
                        .setContentText(message)
                        .setStyle(new NotificationCompat.BigTextStyle().bigText(message))
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true);

        notificationManager.notify(1, builder.build());
    }
}