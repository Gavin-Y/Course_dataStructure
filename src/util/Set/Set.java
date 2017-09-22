package util.Set;

/**
 * Created by yejiaquan on 16/9/15.
 */
public interface Set<T> {                       //���ϳ�����������
    //����
    //����
    boolean     isEmpty();                      //�жϼ����Ƿ�Ϊ��
    int         size();                         //����Ԫ�ظ���
    T           search(T key);                  //���ز��ҵ��Ĺؼ���ΪkeyԪ��
    boolean     contains(T key);                //�ж��Ƿ�����ؼ���ΪkeyԪ��
    boolean     add(T x);                       //����Ԫ��x
    T           remove(T key);                  //ɾ���ؼ���ΪkeyԪ��,���ر�ɾ��Ԫ��
    void        clear();                        //ɾ������Ԫ��
    String      toString();                     //���ؼ�������Ԫ�ص������ַ���
    boolean     equals(Object obj);             //�Ƚ�this��obj���ü����Ƿ����
    Object[]    toArray();                      //���ذ�����������Ԫ�ص�����

    //���·���������������,��������һ������
    boolean     containsAll(Set<?> set);        //�ж��Ƿ����set������Ԫ��(�Ƿ��Ӽ�)
    boolean     addAll(Set<? extends T> set);   //���set������Ԫ��,���ϲ�
    boolean     removeAll(Set<T> set);          //ɾ��Ҳ������set�е�Ԫ��,/*���ϲ�*/
    boolean     retainAll(Set<T> set);          //��������ЩҲ������set�е�Ԫ��,/*���Ͻ�*/
}
