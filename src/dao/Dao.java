package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.Model;

public abstract class Dao<T extends Model> implements Serializable {
    
    private FileOutputStream fileOut;
    private FileInputStream fileIn;
    
    private ObjectOutputStream fileObjectOut;
    private ObjectInputStream fileObjectIn;
    
    private final String path;
    
    public Dao(String path) throws IOException {
        this.path = path;
    }
    
    public Boolean create(T object) {
        try {
            List<T> list = (ArrayList<T>) retrieve();
            
            if (list == null) {
                list = new ArrayList<T>();
            }
            
            if (list.size() == 0) {
                object.setId(1);
            } else {
                object.setId(list.get(list.size() - 1).getId() + 1);
            }
            
            list.add(object);
            
            this.fileOut = new FileOutputStream(this.path);
            this.fileObjectOut = new ObjectOutputStream(this.fileOut);

            this.fileObjectOut.writeObject(list);
            this.fileObjectOut.flush();
            this.fileObjectOut.close();
            
            this.fileOut.flush();
            this.fileOut.close();
            
            return true;
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public T retrieve(int id) { 
        List<T> list = retrieve();
        
        try {
            for (T element : list) {
                if (element.getId() == id) {
                    return element;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public List<T> retrieve() {
        List<T> list;
        
        try {
            
            File file = new File(this.path);
            
            if (!file.exists()) {
                file.createNewFile();
            }
            
            if (file.length() == 0) {
                return null;
            }
            
            this.fileIn = new FileInputStream(this.path);
            this.fileObjectIn = new ObjectInputStream(this.fileIn);
            
            list = (ArrayList<T>) this.fileObjectIn.readObject();
            
            this.fileObjectIn.close();
            this.fileIn.close();
            
            return list;
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public Boolean update(int id, T object) {
        List<T> list = retrieve();
        
        try {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId() == id) {
                    list.set(i, object);
                    break;
                }
            }
            
            this.fileOut = new FileOutputStream(this.path);
            this.fileObjectOut = new ObjectOutputStream(this.fileOut);

            this.fileObjectOut.writeObject(list);
            this.fileObjectOut.flush();
            this.fileObjectOut.close();
            
            this.fileOut.flush();
            this.fileOut.close();
            
            return true;            
        } catch (IOException e) {
            e.printStackTrace();
        }
                
        return false;
    }
    
    public Boolean delete(int id) {
        List<T> list = retrieve();
        
        try {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId() == id) {
                    list.remove(i);
                    break;
                }
            }
            
            this.fileOut = new FileOutputStream(this.path);
            this.fileObjectOut = new ObjectOutputStream(this.fileOut);

            this.fileObjectOut.writeObject(list);
            this.fileObjectOut.flush();
            this.fileObjectOut.close();
            
            this.fileOut.flush();
            this.fileOut.close();
            
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
}
