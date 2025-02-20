class Point3D extends Point2D {
    private float z = 0.0f;

    public Point3D() {
        super();
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x, y);
        this.z = z;
    }

    @Override
    public float[] getXY() {
        return new float[]{x, y, z}; // Lớp 3D trả về mảng chứa cả z
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
