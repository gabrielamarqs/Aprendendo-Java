import java.io.BufferedWriter;
import java.io.FileWriter;

public class GeradorCoresHtml {
    BufferedWriter arqGravacao;

    public static void main(String[] args) throws Exception{
        String nomeArqSaida = "tabela_de_cores_html.html";
        GeradorCoresHtml geradorCores = new GeradorCoresHtml();
        geradorCores.arqGravacao = new BufferedWriter(new FileWriter(nomeArqSaida));
        geradorCores.headerHtml();
        geradorCores.coresLoop();
        geradorCores.arqGravacao.close();
    }
    private void headerHtml() throws Exception{
        arqGravacao.write("<html><head><title>Tabela de Cores HTML</title><meta http-equiv='Content-Type' content='text/html; charset=UTF-8'></head>");
        arqGravacao.newLine();

        arqGravacao.write("<body><p>&nbsp;</p><h2 align='center'>Tabela de Cores HTML</h2><table width='400' align='center' border='1'><tr><th width='200' align='center'>Cor</th><th width='200' align='center'>Código Hexadecimal</th></tr>");
        arqGravacao.newLine();
    }

    private void coresLoop() throws Exception{
        String[] hexa = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        
        
        for(int c = 0; c < hexa.length; c++){
            for(int b = 0; b < hexa.length; b++){
                for(int a = 0; a < hexa.length; a++){
                    String cor = hexa[c] + "0"+ hexa[b] + "0" + hexa[a] + "0";
                    arqGravacao.write("<tr><td bgcolor='#" + cor +"'></td><td align='center'>#"+cor+"</td></tr>");
                    arqGravacao.newLine();
                }
            }
        }
        arqGravacao.write("</table></body></html>");
    }
}
