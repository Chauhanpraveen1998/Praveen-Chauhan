import { Injectable } from '@angular/core';
import { Pool, PoolClient } from 'pg';

@Injectable({
  providedIn: 'root'
})
export class DatabaseService {
  private pool: Pool;

  constructor() {
    this.pool = new Pool({
      user: 'myuser',
      host: 'localhost',
      database: 'mydatabase',
      password: 'mypassword',
      port: 5432
    });
  }

  async query(sql: string, params?: any[]): Promise<any> {
    const client: PoolClient = await this.pool.connect();
    try {
      const result = await client.query(sql, params);
      return result.rows;
    } finally {
      client.release();
    }
  }
}
