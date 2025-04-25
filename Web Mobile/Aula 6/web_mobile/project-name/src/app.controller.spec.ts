import { Test, TestingModule } from '@nestjs/testing';
import { AppController } from './app.controller';
import { AppService } from './app.service';

describe('AppController', () => {
  let appController: AppController;

  beforeEach(async () => {
    const app: TestingModule = await Test.createTestingModule({
      controllers: [AppController],
      providers: [AppService],
    }).compile();

    appController = app.get<AppController>(AppController);
  });

  describe('convert', () => {
    it('should convert R$ to $ correctly', () => {
      const result = appController.convert('100', 'R$', '$', '5.20');
      expect(result).toBe(
        'O valor R$ 100.00 convertido para $ com cotação de R$ 5.20 é $ 19.23.',
      );
    });

    it('should convert $ to R$ correctly', () => {
      const result = appController.convert('50', '$', 'R$', '5.20');
      expect(result).toBe(
        'O valor $ 50.00 convertido para R$ com cotação de R$ 5.20 é R$ 260.00.',
      );
    });

    it('should return same value when currencies are equal', () => {
      const result = appController.convert('100', 'R$', 'R$', '5.20');
      expect(result).toBe(
        'O valor R$ 100.00 convertido para R$ com cotação de R$ 5.20 é R$ 100.00.',
      );
    });
  });
});
