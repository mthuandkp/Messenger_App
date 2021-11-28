/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.BlockDAO;
import DAO.FriendDAO;
import DAO.Join_RoomDAO;
import DAO.MessageDAO;
import DAO.RoomDAO;
import DAO.UserDAO;
import DAO.ViewMessageDAO;
import DTO.Block;
import DTO.Friend;
import DTO.Hyrid_Encryption;
import DTO.Join_Room;
import DTO.Message;
import DTO.Room;
import DTO.User;
import DTO.View_Message;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mthuan
 */
public class ClassBUS {

    UserDAO userdao = new UserDAO();
    RoomDAO roomdao = new RoomDAO();
    Join_RoomDAO jroomdao = new Join_RoomDAO();
    BlockDAO blockdao = new BlockDAO();
    FriendDAO frienddao = new FriendDAO();
    MessageDAO messagedao = new MessageDAO();
    ViewMessageDAO viewmessdao = new ViewMessageDAO();
    

    public String addNewAccount(User user) {
        User userDB = userdao.getUserByEmail(user.getEmail());
        if (userDB != null) {
            return "Email đã tồn tại";
        }
        boolean add = userdao.addNewAccount(user);

        if (add) {
            return "Đăng ký thành công";
        }
        return "Không thể đăng ký";
    }

    public String activeAccout(String email) {
        boolean status = userdao.activeAccout(email);

        return status ? "Kích hoạt tài khoản thành công" : "Không thể kích hoạt";
    }

    public String checkLogin(String email, String pass) {
        User userDB = userdao.getUserByEmail(email);
        if (userDB == null) {
            return "Tài khoản không tồn tại";
        } else if (userDB.getPassword().compareTo(Hyrid_Encryption.convertToMd5(pass)) != 0) {
            return "Mật khẩu không chính xác";
        } else if (!userDB.isIsActive()) {
            return "Tài khoản chưa đc kích hoạt";
        } else {
            //Chuyen tang thai dang nhap thanh true
            boolean rs = userdao.updateOnlineStatus(email,true);
            if (!rs) {
                return "Không thể đăng nhập lỗi khi thay đổi trạng thái online ";
            }
            return "Đăng nhập thành công. Chào mừng trở lại";
        }
    }

    public User getUserByEmail(String email) {
        return userdao.getUserByEmail(email);
    }

    public List<Room> getAllRoom_Rblock_R11JoinByIdUser(int id) {
        List<Join_Room> listJroom = jroomdao.getAllJoin_RoomByIdUser(id);
        List<Block> listBlock = blockdao.getById(id);
        List<Room> listRoom = roomdao.getAllRoom();
        List<Room> filterRoom = new ArrayList<>();

        for (Room room : listRoom) {
            room.setIs_block(false);
            room.setIs_join(false);

            if (room.isGroup_chat()) {
                // Kiem tra tham gia
                for (Join_Room jroom : listJroom) {
                    if (jroom.getId_user() == id && jroom.getId_room() == room.getId()) {
                        room.setIs_join(true);
                        break;
                    }
                }

                //Kiem tra block
                for (Block block : listBlock) {
                    if (block.getId_user() == id && block.getId_room() == room.getId()) {
                        room.setIs_block(true);
                        break;
                    }
                }
                filterRoom.add(room);
            } else {
                Room tmp = null;
                for (Join_Room jroom : listJroom) {
                    if (jroom.getId_user() == id && jroom.getId_room() == room.getId()) {
                        room.setIs_join(true);
                        tmp = room;
                        break;
                    }
                }

                if (tmp != null) {
                    //Kiem tra block
                    for (Block block : listBlock) {
                        if (block.getId_user() == id && block.getId_room() == room.getId()) {
                            room.setIs_block(true);
                            break;
                        }
                    }
                    filterRoom.add(tmp);
                }
            }
        }

        return filterRoom;
    }
    
    public static void main(String[] args) {
        ClassBUS bus = new ClassBUS();
        
    }

    public String accountOffline(String str, boolean b) {
        userdao.updateOnlineStatus(str, b);
        return null;
    }
    
    public List<User> getAllUsersWithFriend(int id){
        List<User> listUser = userdao.getAllUser();
        List<Friend> listFriend = frienddao.getAllFriend();
        
        for(User user : listUser){
            //Kiem tra friend
            for(Friend friend : listFriend){
                if(friend.getId_user_2() == id){
                    user.setIsFriend(true);
                    break;
                }
            }
        }
        
        return listUser;
    }

    public String blockUserById(String idUser, String idRoom) {
        return blockdao.addNewBlock(idUser,idRoom) ? "Khóa thành công":"Lỗi khi khóa";
    }

    public String unblockUserById(String idUser, String idRoom) {
        return blockdao.removeNewBlock(idUser,idRoom) ? "Mở Khóa thành công":"Lỗi khi mở khóa";
    }

    public String joinRoom(String idUser, String idRoom) {
        return blockdao.joinRoom(idUser,idRoom) ? "Tham gia phòng thành công ":"Lỗi khi tham gia phòng";
    }

    public String loadAllMessByIdRoom(Room room) {
        List<Message> listMess = messagedao.getAllMessage();
        List<User> listUser = userdao.getAllUser();
        List<Message> result = new ArrayList<>();
        
        for(Message mess : listMess){
            if(mess.getId_room() == room.getId()){
                for(User u : listUser){
                    if(u.getId() == mess.getId_user()){
                        mess.setUsername(u.getName());
                    }
                }
                result.add(mess);
            }
        }
        
        return new Gson().toJson(result);
    }

    public String checkNewAccount(User user) {
        User userDB = userdao.getUserByEmail(user.getEmail());
        if (userDB != null) {
            return "Email đã tồn tại";
        }
        return "SUCCESS";
    }

    public void addNewMessage(int idRoom, int idUser, String chatcontent) {
        messagedao.addNewMessage(idRoom,idUser,chatcontent);
    }

    public String getAllViewMess() {
        return new Gson().toJson(viewmessdao.getAllViewMess());
    }

    public void ViewAllMessage(int idRoom, int idUser) {
        List<Message> messageList = messagedao.getAllMessageByIdRoom(idRoom);
        List<View_Message> viewMessList = viewmessdao.getAllViewMess();
        for(Message mess : messageList){
            if(mess.getId_user() == idUser){
                continue;
            }
            //Them cap idMess - idUser
            boolean isExistView = false;
            for(View_Message vm : viewMessList){
                if(vm.getId_user() == idUser && vm.getId_mess() == mess.getId()){
                    isExistView = true;
                    break;
                }
            }
            if(isExistView){
                continue;
            }
            
            viewmessdao.addNewView(mess.getId(),idUser);
        }
    }
}
