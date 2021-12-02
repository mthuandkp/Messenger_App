/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.BlockGroupDAO;
import DAO.BlockUserDAO;
import DAO.FriendDAO;
import DAO.GroupChatDAO;
import DAO.JoinGroupDAO;
import DAO.MessageGroupDAO;
import DAO.Message_11DAO;
import DAO.UserDAO;
import DAO.ViewMessage11DAO;
import DAO.ViewMessageGroupDAO;
import DTO.BlockGroupDTO;
import DTO.BlockUserDTO;
import DTO.FriendDTO;
import DTO.GroupChatDTO;
import DTO.JoinGroupDTO;
import DTO.MessageGroupDTO;
import DTO.Message_11DTO;
import DTO.UserDTO;
import DTO.ViewMessageDTO;
import Func.Hyrid_Encryption;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mthuan
 */
public class ClassBUS {

    UserDAO userdao = new UserDAO();
    GroupChatDAO groupchatdao = new GroupChatDAO();
    JoinGroupDAO joingroupdao = new JoinGroupDAO();
    BlockGroupDAO blockgroupdao = new BlockGroupDAO();
    MessageGroupDAO messagegroupdao = new MessageGroupDAO();
    FriendDAO frienddao = new FriendDAO();
    BlockUserDAO blockUserdao = new BlockUserDAO();
    Message_11DAO message11dao = new Message_11DAO();
    ViewMessage11DAO viewmess11dao = new ViewMessage11DAO();
    ViewMessageGroupDAO viewmessgroupdao = new ViewMessageGroupDAO();

    public String checkLogin(String email, String pass) {
        UserDTO userDB = userdao.getUserByEmail(email);
        if (userDB == null) {
            return "Tài khoản không tồn tại";
        } else if (userDB.getPassword().compareTo(Hyrid_Encryption.convertToMd5(pass)) != 0) {
            return "Mật khẩu không chính xác";
        } else if (!userDB.isIsActive()) {
            return "Tài khoản chưa đc kích hoạt";
        } else {
            //Chuyen tang thai dang nhap thanh true
            boolean rs = userdao.updateOnlineStatus(email, true);
            if (!rs) {
                return "Không thể đăng nhập lỗi khi thay đổi trạng thái online ";
            }
            return "Đăng nhập thành công. Chào mừng trở lại";
        }
    }

    public UserDTO getUserByEmail(String email) {
        return userdao.getUserByEmail(email);
    }

    public String activeAccout(String email) {
        boolean status = userdao.activeAccout(email);

        return status ? "Kích hoạt tài khoản thành công" : "Không thể kích hoạt";
    }

    public String checkNewAccount(UserDTO user) {
        UserDTO userDB = userdao.getUserByEmail(user.getEmail());
        if (userDB != null) {
            return "Email đã tồn tại";
        }
        return "SUCCESS";
    }

    public String addNewAccount(UserDTO user) {
        UserDTO userDB = userdao.getUserByEmail(user.getEmail());
        if (userDB != null) {
            return "Email đã tồn tại";
        }
        boolean add = userdao.addNewAccount(user);

        if (add) {
            return "Đăng ký thành công";
        }
        return "Không thể đăng ký";
    }

    public String getAllGroupChatWithoutBlock(int id) {
        List<GroupChatDTO> listGroup = groupchatdao.getAllGroup();
        List<JoinGroupDTO> listJoinGroup = joingroupdao.getAllJoinGroup();
        List<BlockGroupDTO> listBlockGroup = blockgroupdao.getAllBlockGroup();
        List<MessageGroupDTO> listMessageGroup = messagegroupdao.getAllMessage();
        List<UserDTO> listUser = userdao.getAllUser();
        List<GroupChatDTO> listGroupResult = new ArrayList<>();

        //Duyet qua tat ca cac group
        for (GroupChatDTO groupchat : listGroup) {
            boolean check = false;
            if (listBlockGroup != null) {
                //kiem tra phong co bi block hay khong
                for (BlockGroupDTO blockgroup : listBlockGroup) {
                    if (blockgroup.getId_group() == groupchat.getId_group() && blockgroup.getId_user() == id) {
                        check = true;
                        break;
                    }
                }
            }

            if (check) {
                continue;
            }
            groupchat.setIsBlock(false);
            // kiem tra xem nguoi dung co tham gia phong hay chua
            groupchat.setIsJoin(false);
            if (listJoinGroup != null) {
                for (JoinGroupDTO joingroup : listJoinGroup) {
                    if (joingroup.getId_group() == groupchat.getId_group() && joingroup.getId_user() == id) {
                        groupchat.setIsJoin(true);
                        break;
                    }
                }
            }

            //Lay tin nhan cuoi cung cua nhom
            String lastMessage = "";
            for (MessageGroupDTO messagegroup : listMessageGroup) {
                if (messagegroup.getId_group() == groupchat.getId_group()) {
                    //Lay ten nguoi cua tin nha cuoi do
                    for (UserDTO user : listUser) {
                        if (user.getId() == messagegroup.getId_user()) {
                            lastMessage = user.getName() + " : " + (messagegroup.isIsURL() ? "Đã gửi 1 liên kết" : messagegroup.getContent());
                        }
                    }
                }
            }
            groupchat.setNearlyMessage(lastMessage);
            listGroupResult.add(groupchat);
        }

        return new Gson().toJson(listGroupResult);
    }

    public String getAllUserWithoutBlock(int id) {
        List<UserDTO> listUser = userdao.getAllUser();
        List<FriendDTO> listFriend = frienddao.getAllFriend();
        List<BlockUserDTO> listBlockUser = blockUserdao.getAllListBlock();
        List<Message_11DTO> listMessage11 = message11dao.getAllMessage();
        List<UserDTO> listUserReturn = new ArrayList<>();

        //Loai bo nhung user dang bi block va user dang login
        for (UserDTO user : listUser) {
            //Bo qua user hien tai
            if (user.getId() == id) {
                continue;
            }
            //tra trong bang block
            boolean checkBlock = false;
            if (listBlockUser != null) {
                for (BlockUserDTO block : listBlockUser) {
                    if (block.getId_user() == id && block.getId_usr_block() == user.getId() && user.getId() != id) {
                        checkBlock = true;
                        break;
                    }
                }
            }
            if (checkBlock) {
                continue;
            }

            //Kiem tra xem user hien tai co bi 1 user trong listUser block hay khong ?
            boolean checkIsBlock = false;
            if (listBlockUser != null) {
                for (BlockUserDTO block : listBlockUser) {
                    if (block.getId_user() == user.getId() && block.getId_usr_block() == id && user.getId() != id) {
                        checkIsBlock = true;
                        break;
                    }
                }
            }

            if (checkIsBlock) {
                user.setIsBlock(true);
            }

            //Lay tin nhan gan nhat
            String lastMessage = "";
            for (Message_11DTO mess : listMessage11) {
                if (mess.getId_received() == id && mess.getId_sender() == user.getId()) {

                    lastMessage = user.getName() + " : " + (mess.isIsURL() ? "Đã gửi 1 liên kết" : mess.getContent());
                } else if (mess.getId_received() == user.getId() && mess.getId_sender() == id) {
                    //Lay ten nguoi gui
                    String nameUserSend = "";
                    for (UserDTO subuser : listUser) {
                        if (subuser.getId() == id) {
                            nameUserSend = subuser.getName();
                            break;
                        }
                    }
                    lastMessage = nameUserSend + " : " + (mess.isIsURL() ? "Đã gửi 1 liên kết" : mess.getContent());
                }
            }

            user.setLastMessage(lastMessage);
            listUserReturn.add(user);
        }
        return new Gson().toJson(listUserReturn);
    }

    public static void main(String[] args) {
        ClassBUS c = new ClassBUS();
        System.out.println(c.getMessageGroupChat(1, 1));
    }

    public String joinGroupChat(int idUser, int idGroup) {
        if (joingroupdao.joinToGroup(idUser, idGroup)) {
            return "Tham gia thành công";
        }
        return "Lỗi khi tham gia";
    }

    public String getMessageGroupChat(int idUser, int idGroup) {
        List<MessageGroupDTO> listMessageGroup = messagegroupdao.getAllMessage();
        List<ViewMessageDTO> listViewmessGroup = viewmessgroupdao.getAllViewMessage();
        List<UserDTO> listUser = userdao.getAllUser();
        List<MessageGroupDTO> listMessageGroupReturn = new ArrayList<>();

        for (MessageGroupDTO mess : listMessageGroup) {
            if (mess.getId_group() == idGroup) {
                //Tin nhan co phai cua nguoi dang login khong ?
                if (mess.getId_user() == idUser) {
                    mess.setIsOwner(true);
                }
                int idUserMess = mess.getId_user();
                for (UserDTO user : listUser) {
                    if (user.getId() == idUserMess) {
                        mess.setNameUser(user.getName());
                        break;
                    }
                }
                //Lay danh sach nguoi xem
                String viewer = "";
                if (listViewmessGroup != null) {
                    for (ViewMessageDTO view : listViewmessGroup) {
                        if (view.getId_mess() == mess.getId() && view.getId_user() != mess.getId_user()) {
                            int idViewer = view.getId_user();
                            for (UserDTO user : listUser) {
                                if (user.getId() == idViewer) {
                                    viewer += user.getName() + ",";
                                }
                            }
                        }
                    }
                }

                mess.setViewer(viewer);
                listMessageGroupReturn.add(mess);
            }
        }
        return new Gson().toJson(listMessageGroupReturn);
    }

    public String leaveMessageGroupChat(int idUser, int idRoom) {
        if (joingroupdao.removeJoinGroup(idUser, idRoom)) {
            return "Rời phòng chat thành công";
        }
        return "Lỗi khi rời phòng chat";
    }

    public void addNewGroupMessage(int idUser, int idGroup, String content) {
        messagegroupdao.addNewMess(idUser, idGroup, content);
    }

    public void viewAllMessageGroupChat(int idUser, int idGroup) {
        List<ViewMessageDTO> listViewGroup = viewmessgroupdao.getAllViewMessage();
        List<MessageGroupDTO> listMessage = messagegroupdao.getAllMessage();

        for (MessageGroupDTO mess : listMessage) {
            if (mess.getId_group() != idGroup || mess.getId_user() == idUser) {
                continue;
            }
            boolean checkView = false;
            if (listViewGroup != null) {
                for (ViewMessageDTO view : listViewGroup) {
                    if (view.getId_user() == idUser && view.getId_mess() == mess.getId()) {
                        checkView = true;
                        break;
                    }
                }
            }

            if (!checkView) {
                viewmessgroupdao.viewMessage(idUser, mess.getId());
            }
        }
    }

    public void addNewFileMess(int idUser, int idGroup, String filename, byte[] dataFile) {
        MessageGroupDTO mess = new MessageGroupDTO(
                idUser,
                idGroup,
                DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now()),
                filename,
                true
        );
        
        messagegroupdao.addNewMess(mess);
    }

    public void addNewStickerGroupMess(int idUser, int idGroup, String stickername) {
        MessageGroupDTO mess = new MessageGroupDTO(
                idUser,
                idGroup,
                DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now()),
                stickername,
                true
        );
        
        messagegroupdao.addNewMess(mess);
    }

    public void logOutAccount(int id) {
        userdao.logOutAccount(id);
    }
}
