package pemutar_musik;
    import java.io.File;
    import java.io.FileInputStream;
    import java.io.FileOutputStream;
    import java.io.ObjectInputStream;
    import java.io.ObjectOutputStream;
    import java.util.ArrayList;
    import java.util.Arrays;
    import javax.swing.JFileChooser;
    import javax.swing.JFrame;
/**
 *
 * @author ROTAN27
 */
public class daftar_playlist {
    JFileChooser filechooser = new JFileChooser();
    ArrayList list_array = new ArrayList();
    
    void add(JFrame frame){
        filechooser.setMultiSelectionEnabled(true);
        int file_benar = filechooser.showOpenDialog(frame);
        if (file_benar == javax.swing.JFileChooser.CANCEL_OPTION){
            return;
        } else if (file_benar == javax.swing.JFileChooser.APPROVE_OPTION){
            File[] file = filechooser.getSelectedFiles();
            list_array.addAll(Arrays.asList(file));
        }
    }
    
    ArrayList getListSong(){
        return list_array;
    }
    
    
    //save playlist
    FileOutputStream file_output_stream;
    ObjectOutputStream object_output;
    
    public void menyimpan_playlist(JFrame frame){
        filechooser.setMultiSelectionEnabled(false);
        int benar = filechooser.showSaveDialog(frame);
        if (benar == javax.swing.JFileChooser.CANCEL_OPTION){
            return;
        } else if (benar == javax.swing.JFileChooser.APPROVE_OPTION){
            File playlist1 = filechooser.getSelectedFile();
            try{
                file_output_stream = new FileOutputStream(playlist1 + ".tgr");
                object_output = new ObjectOutputStream(file_output_stream);
                for (int i=0; i<list_array.size() ; i++){
                    File sementara = (File) list_array.get(i);
                    object_output.writeObject(sementara);
                }
                object_output.close();
            }
            catch (Exception e){
                
        }
        }
    }
    FileInputStream file_input_stream;
    ObjectInputStream object_input;
    
    public void open_playlist(JFrame frame){
        filechooser.setMultiSelectionEnabled(false);
        int benar = filechooser.showOpenDialog(frame);
        if (benar == javax.swing.JFileChooser.CANCEL_OPTION){
            return;
        }
        if (benar == javax.swing.JFileChooser.APPROVE_OPTION){
            File playlist1 = filechooser.getSelectedFile();
            try{
                file_input_stream = new FileInputStream(playlist1);
                object_input = new ObjectInputStream(file_input_stream);
                File sementara;
                while ((sementara = (File) object_input.readObject()) != null){
                    list_array.add(sementara);
                }
              if ((sementara = (File) object_input.readObject()) == null){
                  list_array.isEmpty();
              }
              object_input.close();
            }catch (Exception e){
        }
        
        }
    }
}
