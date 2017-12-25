
package pemutar_musik;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.*;
import javax.swing.DefaultListModel;
import java.util.ArrayList;
import javax.swing.UIManager;
import javax.swing.ImageIcon;


public class menu_utama extends javax.swing.JFrame {

    daftar_playlist play_lst = new daftar_playlist();
    ArrayList update_playlst = new ArrayList();
    javazoom.jl.player.Player player;
    File simpan;
    
    
    public menu_utama() {
        initComponents();
    }
    
    
    
    void update_playlst() {
        update_playlst = play_lst.getListSong();
        DefaultListModel model =  new DefaultListModel();
        for (int i = 0; i < update_playlst.size(); i++) {
            int j = i + 1;
            model.add(i, j + " | " + ((File) update_playlst.get(i)).getName());
        }
        daftar_list.setModel(model);

    }
    
    //pengontrol mp3
    
    void add(){
        play_lst.add(this);
        update_playlst();
    }
    
    void open(){
        play_lst.membuka_playlist(this);
        update_playlst();
    }
    
    void save(){
        play_lst.simpan_playlist(this);
        update_playlst();
    }
    
    void remove(){
        try {
            int akandihapus = daftar_list.getLeadSelectionIndex();
            play_lst.list_array.remove(akandihapus);
            update_playlst();
        } catch (Exception e) {
        }
    }
    
    void up(){ 
        try {
            int metod1 = daftar_list.getLeadSelectionIndex();
            simpan = (File) play_lst.list_array.get(metod1);
            play_lst.list_array.remove(metod1);
            play_lst.list_array.add(metod1 - 1, simpan );
            update_playlst();
            daftar_list.setSelectedIndex(metod1-1);
        } catch (Exception e) {
        }
    }
    
    void down(){
        try {
            int metod1 = daftar_list.getLeadSelectionIndex();
            simpan = (File) play_lst.list_array.get(metod1);
            play_lst.list_array.remove(metod1);
            play_lst.list_array.add(metod1 + 1, simpan );
            update_playlst();
            daftar_list.setSelectedIndex(metod1+1);
        } catch (Exception e) {
        }
    }
    
    //pengontrol musik
    File memutar1;
    static int a = 0;

void putar(){
    if(a==0){
        try{
            int m1 = daftar_list.getSelectedIndex();
            memutar1 = (File) this.update_playlst.get(m1);
            FileInputStream file_input_stream = new FileInputStream(memutar1);
            BufferedInputStream buffered_input_stream = new BufferedInputStream(file_input_stream);
            player = new javazoom.jl.player.Player(buffered_input_stream);
            a =1;
        }catch(Exception e){
            System.out.println("Lagu Gagal DI Putar, Ada Kesalahan pada Code");
            System.out.println(e);
        }
        
        new Thread(){
            @Override
            public void run(){
                try{
                    player.play();
                
            }catch (Exception e){
            }
        }
    }.start();
    }else{
        player.close();
        a=0;
        putar();
    }
}


File metode;    //sa = metode //s1 = metod1
void next(){
    if(a==0){
        try{
            int metod1 = daftar_list.getSelectedIndex() +1;
            metode = (File) this.play_lst.list_array.get(metod1);
            FileInputStream file_input_stream = new FileInputStream(metode);
            BufferedInputStream buffered_input_stream = new BufferedInputStream(file_input_stream);
            player = new javazoom.jl.player.Player(buffered_input_stream);
            a =1;
            daftar_list.setSelectedIndex(metod1);
        }catch(Exception e){
            System.out.println("Lagu Gagal DI Putar, Ada Kesalahan pada Code");
            System.out.println(e);
        }
        
        new Thread(){
            @Override
            public void run(){
                try{
                    player.play();
                
            }catch (Exception e){
            }
        }
    }.start();
    }else{
        player.close();
        a=0;
        next();
    }

}



void previous(){
    if(a==0){
        try{
            int metod1 = daftar_list.getSelectedIndex() -1;
            metode = (File) this.play_lst.list_array.get(metod1);
            FileInputStream file_input_stream = new FileInputStream(metode);
            BufferedInputStream buffered_input_stream = new BufferedInputStream(file_input_stream);
            player = new javazoom.jl.player.Player(buffered_input_stream);
            a =1;
            daftar_list.setSelectedIndex(metod1);
        }catch(Exception e){
            System.out.println("Lagu Gagal DI Putar, Ada Kesalahan pada Code");
            System.out.println(e);
        }
        
        new Thread(){
            @Override
            public void run(){
                try{
                    player.play();
                
            }catch (Exception e){
            }
        }
    }.start();
    }else{
        player.close();
        a=0;
        previous();
    }
}
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_add2 = new javax.swing.JButton();
        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        daftar_list = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btn_add = new javax.swing.JButton();
        btn_open = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_remove = new javax.swing.JButton();
        btn_up = new javax.swing.JButton();
        btn_down = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        logo_play = new javax.swing.JLabel();
        logo_next = new javax.swing.JLabel();
        logo_previous = new javax.swing.JLabel();
        logo_stop = new javax.swing.JLabel();
        logo_pause = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        btn_add2.setBackground(new java.awt.Color(0, 102, 102));
        btn_add2.setFont(new java.awt.Font("Malayalam Sangam MN", 0, 13)); // NOI18N
        btn_add2.setText("PLAY");

        jMenuItem1.setText("jMenuItem1");

        jLabel3.setText("jLabel3");

        jLabel12.setFont(new java.awt.Font("Monaco", 1, 12)); // NOI18N
        jLabel12.setText("15101152610308");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        daftar_list.setBackground(new java.awt.Color(102, 102, 102));
        daftar_list.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                daftar_listAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        daftar_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                daftar_listMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                daftar_listMouseClicked(evt);
            }
        });
        daftar_list.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                daftar_listKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(daftar_list);

        jLabel1.setFont(new java.awt.Font("Malayalam Sangam MN", 1, 18)); // NOI18N
        jLabel1.setText("Daftar Playlist Musik");

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btn_add.setBackground(new java.awt.Color(51, 51, 51));
        btn_add.setFont(new java.awt.Font("Malayalam Sangam MN", 0, 13)); // NOI18N
        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/p_add.png"))); // NOI18N
        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_open.setBackground(new java.awt.Color(51, 51, 51));
        btn_open.setFont(new java.awt.Font("Malayalam Sangam MN", 0, 13)); // NOI18N
        btn_open.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/p_open.png"))); // NOI18N
        btn_open.setText("Open");
        btn_open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_openActionPerformed(evt);
            }
        });

        btn_save.setBackground(new java.awt.Color(51, 51, 51));
        btn_save.setFont(new java.awt.Font("Malayalam Sangam MN", 0, 13)); // NOI18N
        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/p_save.png"))); // NOI18N
        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_remove.setBackground(new java.awt.Color(51, 51, 51));
        btn_remove.setFont(new java.awt.Font("Malayalam Sangam MN", 0, 13)); // NOI18N
        btn_remove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/p_remove.png"))); // NOI18N
        btn_remove.setText("Remove");
        btn_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeActionPerformed(evt);
            }
        });

        btn_up.setBackground(new java.awt.Color(51, 51, 51));
        btn_up.setFont(new java.awt.Font("Malayalam Sangam MN", 0, 13)); // NOI18N
        btn_up.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/p_up.png"))); // NOI18N
        btn_up.setText("Up");
        btn_up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_upActionPerformed(evt);
            }
        });

        btn_down.setBackground(new java.awt.Color(51, 51, 51));
        btn_down.setFont(new java.awt.Font("Malayalam Sangam MN", 0, 13)); // NOI18N
        btn_down.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/p_down.png"))); // NOI18N
        btn_down.setText("Down");
        btn_down.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_downActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_open, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_remove)
                    .addComponent(btn_save, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_up, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_down, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_up, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_down, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_remove, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_open, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        logo_play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/tombol_play.png"))); // NOI18N
        logo_play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logo_playMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logo_playMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logo_playMouseEntered(evt);
            }
        });

        logo_next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/tombol_next.png"))); // NOI18N
        logo_next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logo_nextMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logo_nextMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logo_nextMouseEntered(evt);
            }
        });

        logo_previous.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/tombol_prev.png"))); // NOI18N
        logo_previous.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logo_previousMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logo_previousMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logo_previousMouseEntered(evt);
            }
        });

        logo_stop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/tombol_stop.png"))); // NOI18N
        logo_stop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logo_stopMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logo_stopMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logo_stopMouseEntered(evt);
            }
        });

        logo_pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/tombol_pause.png"))); // NOI18N
        logo_pause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logo_pauseMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logo_pauseMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logo_pauseMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(logo_pause)
                .addGap(18, 18, 18)
                .addComponent(logo_previous)
                .addGap(18, 18, 18)
                .addComponent(logo_play)
                .addGap(18, 18, 18)
                .addComponent(logo_next)
                .addGap(18, 18, 18)
                .addComponent(logo_stop)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logo_pause)
                    .addComponent(logo_previous)
                    .addComponent(logo_stop)
                    .addComponent(logo_play)
                    .addComponent(logo_next))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Malayalam Sangam MN", 1, 13)); // NOI18N
        jLabel7.setText("©2017");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(288, 288, 288)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Monaco", 1, 18)); // NOI18N
        jLabel2.setText("Nama Kelompok");

        jLabel4.setFont(new java.awt.Font("Monaco", 1, 13)); // NOI18N
        jLabel4.setText("Alfiona Lhathifa");

        jLabel5.setFont(new java.awt.Font("Monaco", 1, 12)); // NOI18N
        jLabel5.setText("15101152610308");

        jLabel6.setFont(new java.awt.Font("Monaco", 1, 13)); // NOI18N
        jLabel6.setText("Latifa Chania");

        jLabel9.setFont(new java.awt.Font("Monaco", 1, 13)); // NOI18N
        jLabel9.setText("Mizona Indriani");

        jLabel10.setFont(new java.awt.Font("Monaco", 1, 13)); // NOI18N
        jLabel10.setText("Ressy Wiliya Putri");

        jLabel8.setFont(new java.awt.Font("Monaco", 1, 12)); // NOI18N
        jLabel8.setText("00000000000000");

        jLabel11.setFont(new java.awt.Font("Monaco", 1, 12)); // NOI18N
        jLabel11.setText("00000000000000");

        jLabel13.setFont(new java.awt.Font("Monaco", 1, 12)); // NOI18N
        jLabel13.setText("00000000000000");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(235, 235, 235)
                                    .addComponent(jLabel1))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(629, 513));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:
        save();
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        add();
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeActionPerformed
        // TODO add your handling code here:
        remove();
    }//GEN-LAST:event_btn_removeActionPerformed

    private void logo_playMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logo_playMouseClicked
        // TODO add your handling code here:
        putar();
    }//GEN-LAST:event_logo_playMouseClicked

    private void btn_openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_openActionPerformed
        // TODO add your handling code here:
        open();
    }//GEN-LAST:event_btn_openActionPerformed

    private void btn_upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_upActionPerformed
        // TODO add your handling code here:
        up();
    }//GEN-LAST:event_btn_upActionPerformed

    private void btn_downActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_downActionPerformed
        // TODO add your handling code here:
        down();
    }//GEN-LAST:event_btn_downActionPerformed

    private void logo_stopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logo_stopMouseClicked
        // TODO add your handling code here:
        player.close();
    }//GEN-LAST:event_logo_stopMouseClicked

    private void daftar_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_daftar_listMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_daftar_listMouseClicked

    private void logo_playMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logo_playMouseEntered
        // TODO add your handling code here:
        logo_play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/tombol_play_hover.png")));
    }//GEN-LAST:event_logo_playMouseEntered

    private void logo_playMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logo_playMouseExited
        // TODO add your handling code here:
        logo_play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/tombol_play.png")));
    }//GEN-LAST:event_logo_playMouseExited

    private void logo_nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logo_nextMouseClicked
        // TODO add your handling code here:
        next();
    }//GEN-LAST:event_logo_nextMouseClicked

    private void logo_nextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logo_nextMouseEntered
        // TODO add your handling code here:
        logo_next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/tombol_next_hover.png")));
    }//GEN-LAST:event_logo_nextMouseEntered

    private void logo_nextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logo_nextMouseExited
        // TODO add your handling code here:
        logo_next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/tombol_next.png")));
    }//GEN-LAST:event_logo_nextMouseExited

    private void logo_stopMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logo_stopMouseEntered
        // TODO add your handling code here:
        logo_stop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/tombol_stop_hover.png")));
    }//GEN-LAST:event_logo_stopMouseEntered

    private void logo_stopMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logo_stopMouseExited
        // TODO add your handling code here:
        logo_stop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/tombol_stop.png")));
    }//GEN-LAST:event_logo_stopMouseExited

    private void logo_previousMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logo_previousMouseClicked
        // TODO add your handling code here:
        previous();
    }//GEN-LAST:event_logo_previousMouseClicked

    private void logo_previousMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logo_previousMouseEntered
        // TODO add your handling code here:
        logo_previous.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/tombol_prev_hover.png")));
    }//GEN-LAST:event_logo_previousMouseEntered

    private void logo_previousMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logo_previousMouseExited
        // TODO add your handling code here:
        logo_previous.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/tombol_prev.png")));
    }//GEN-LAST:event_logo_previousMouseExited

    private void logo_pauseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logo_pauseMouseClicked
        // TODO add your handling code here:
        player.close();
    }//GEN-LAST:event_logo_pauseMouseClicked

    private void logo_pauseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logo_pauseMouseEntered
        // TODO add your handling code here:
        logo_pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/tombol_pause_hover.png")));
    }//GEN-LAST:event_logo_pauseMouseEntered

    private void logo_pauseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logo_pauseMouseExited
        // TODO add your handling code here:
        logo_pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/tombol_pause.png")));
    }//GEN-LAST:event_logo_pauseMouseExited

    private void daftar_listMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_daftar_listMousePressed
        // TODO add your handling code here:
        putar();
    }//GEN-LAST:event_daftar_listMousePressed

    private void daftar_listKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_daftar_listKeyPressed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_daftar_listKeyPressed

    private void daftar_listAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_daftar_listAncestorAdded
        // TODO add your handling code here:
        

        
    }//GEN-LAST:event_daftar_listAncestorAdded

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menu_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu_utama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_add2;
    private javax.swing.JButton btn_down;
    private javax.swing.JButton btn_open;
    private javax.swing.JButton btn_remove;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_up;
    private javax.swing.JList<String> daftar_list;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logo_next;
    private javax.swing.JLabel logo_pause;
    private javax.swing.JLabel logo_play;
    private javax.swing.JLabel logo_previous;
    private javax.swing.JLabel logo_stop;
    // End of variables declaration//GEN-END:variables
}
