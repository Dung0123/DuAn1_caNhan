/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.ThongkeService.impl;

import DomainModels.QLThongKe;
import DomainModels.QLThongkeBanHang;
import java.util.ArrayList;
import java.util.Date;
import model.ThongKe;
import model.ThongkeBanHang;
import repository.ThongkeRepository.impl.ThongKeRepository;
import service.ThongkeService.IThongKeService;

/**
 *
 * @author ledun
 */
public class ThongKeSerivrce implements IThongKeService {

    ArrayList<QLThongKe> list = new ArrayList<>();
    ArrayList<QLThongkeBanHang> listBanHang = new ArrayList<>();
    ThongKeRepository repo = new ThongKeRepository();

    @Override
    public ArrayList<QLThongKe> selectAllSanPhamBanchay() {
        var lst = repo.selectAllSanPhamBanchay();
         list.clear();
        for (ThongKe tk : lst) {
            list.add(new QLThongKe(tk.getMa(), tk.getTen(), tk.getSoLuong(), tk.getGiaBan(),
                    tk.getTongTien(), tk.getTrangThai()));
        }
        return list;
    }

    @Override
    public ArrayList<QLThongKe> selectAllSanPhamTon() {
        var lst = repo.selectAllSanPhamTon();
        list.clear();
        for (ThongKe tk : lst) {
            list.add(new QLThongKe(tk.getMa(), tk.getTen(), tk.getSoLuong(), tk.getGiaBan(),
                    tk.getTongTien(), tk.getTrangThai()));
        }
        return list;
    }

    @Override
    public ArrayList<QLThongkeBanHang> selectcBanHang() {
        var lst = repo.selectcBanHang();
        listBanHang.clear();
        for (ThongkeBanHang tk : lst) {
            listBanHang.add(new QLThongkeBanHang(tk.getMa(), tk.getTen(), tk.getSoLuong(), tk.getTongTien()));
        }
        return listBanHang;
    }

    @Override
    public ArrayList<QLThongkeBanHang> SeleccLocBanHang(Date bd, Date kt) {
        var lst = repo.SeleccLocBanHang(bd,kt);   
        listBanHang.clear();
        for (ThongkeBanHang tk : lst) {
            listBanHang.add(new QLThongkeBanHang(tk.getMa(), tk.getTen(), tk.getSoLuong(), tk.getTongTien()));
        }
        return listBanHang;
    }

    @Override
    public ArrayList<QLThongkeBanHang> selectcBanHangByTimkiem(String Ma) {
        var lst = repo.selectcBanHangbyten(Ma);
         listBanHang.clear();
        for (ThongkeBanHang tk : lst) {
            listBanHang.add(new QLThongkeBanHang(tk.getMa(), tk.getTen(), tk.getSoLuong(), tk.getTongTien()));
        }
        return listBanHang;
    }

}
